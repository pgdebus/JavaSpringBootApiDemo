package au.com.formis.springbootdemo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author      <a href="mailto:peter.debus@formis.com.au">Peter Debus</a>
 * @version     0.1
 *
 *
 * <p>A controller class to process REST API requests for MotorVehicle data.</p>
 * <p></p>
 * <p>The context root mapping for the REST API is /motorVehicles followed by Get query parameters.
 * Query parameter permutations are mapped to the JPQL queries defined in MotorVehicleRepository.</p>
 * <p></p>
 * <p>Currently the response publisher and payloadDescription string class variables hold hard wired strings
 * as this is just a demo.
 * </p>
 * <p>The controller uses Spring field injection for the MotorVehicleRepository interface using the @Autowired
 * annotation.</p>
 * <p>#TODO: Resolve field injection is not recommended warning.</p>
 * <p>
 *     @RestController is a convenient annotation that combines @Controller and @ResponseBody annotations.
 * </p>
 * <p>
 * The List of entities returned by the MotorVehicleRepository are encapsulated in an
 * ApiResponsePayload class along with some accompanying data for publisher, payload description
 * and API request URL to be returned in the JSON data.
 * </p>
 * <p>
 * @see au.com.formis.springbootdemo.MotorVehicleRepository
 * @see au.com.formis.springbootdemo.MotorVehicle
 * @see au.com.formis.springbootdemo.ApiResponsePayload
 * @see org.springframework.beans.factory.annotation
 * @since       0.1
 * </p>
 */
@RestController
public class MotorVehicleController {

    // Hard wired strings used, this is just a demo.
    private static final String publisher = "Spring Boot Demo Service";
    private static final String payloadDescription = "Motor vehicle data set";

    @Autowired
    private MotorVehicleRepository motorVehicleRepository;

    /**
     * <p>Controller for /motorVehicles when no query parameters are defined, returns and empty payload
     * with http error 405 to avoid dumping entire database.</p>
     * @param request Request object for REST API query, used to fetch original URL.
     * @param response Response object for API response, used to see http error code 405.
     * @return ApiResponsePayload containing response JSON metadata and empty List.
     */
    @RequestMapping(value = "/motorVehicles",  method = RequestMethod.GET)
    public ApiResponsePayload<MotorVehicle> motorVehicleNoParams(HttpServletRequest request, HttpServletResponse response) {
        List<MotorVehicle> emptyPayload = new ArrayList<MotorVehicle>();
        response.setStatus((HttpServletResponse.SC_METHOD_NOT_ALLOWED));
        return new ApiResponsePayload<MotorVehicle>(publisher, payloadDescription, request.getRequestURL().toString(), emptyPayload);
    }

    /**
     * <p>Controller for /motorVehicles with only the make query parameter defined.
     * </p>
     *
     * @param make The make REST query parameter.
     * @param request Request object for REST API query, used to fetch original URL.
     * @return ApiResponsePayload containing response JSON metadata and List of MotorVehicle entities.
     */
    // #Note : @GetMapping is a composed annotation shortcut for @RequestMapping(method=RequestMethod.Get).
    // @RequestMapping can be class and method level, @GetMapping is method level only.
    // @RequestMapping provides easy to read mapping for defined query parameters.
    // @GetMapping("/motorVehicles")
    @RequestMapping(value = "/motorVehicles", params = {"make"}, method = RequestMethod.GET)
    public ApiResponsePayload<MotorVehicle> motorVehicleMake(@RequestParam(value = "make") String make, HttpServletRequest request) {
        return new ApiResponsePayload<MotorVehicle>(publisher, payloadDescription, request.getRequestURL().append('?').append(request.getQueryString()).toString(), motorVehicleRepository.findMotorVehiclesByMake(make));
    }

    /**
     * <p>Controller for /motorVehicles with the make AND model query parameters defined.
     * </p>
     *
     * @param make The make REST query parameter.
     * @param model The model REST query parameter.
     * @param request Request object for REST API query, used to fetch original URL.
     * @return ApiResponsePayload containing response JSON metadata and List of MotorVehicle entities.
     */
    @RequestMapping(value = "/motorVehicles", params = {"make", "model"}, method = RequestMethod.GET)
    public ApiResponsePayload<MotorVehicle> motorVehicleMakeAndModel(@RequestParam(value = "make") String make, @RequestParam(value = "model") String model, HttpServletRequest request) {
        return new ApiResponsePayload<MotorVehicle>(publisher, payloadDescription, request.getRequestURL().append('?').append(request.getQueryString()).toString(), motorVehicleRepository.findMotorVehiclesByMakeAndModel(make, model));
    }

    /**
     * <p>Controller for /motorVehicles with the make AND model AND generation query parameters defined.
     * The generation value is used as a 'contains' case insensitive match when performing the query while
     * make and model use strict equality in the query.
     * </p>
     *
     * @param make The make REST query parameter.
     * @param model The model REST query parameter.
     * @param generation The generation REST query parameter.
     * @param request Request object for REST API query, used to fetch original URL.
     * @return ApiResponsePayload containing response JSON metadata and List of MotorVehicle entities.
     */
    @RequestMapping(value = "/motorVehicles", params = {"make", "model", "generation"}, method = RequestMethod.GET)
    public ApiResponsePayload<MotorVehicle> motorVehicleMakeAndModelAndGeneration(@RequestParam(value = "make") String make, @RequestParam(value = "model") String model, @RequestParam(value = "generation") String generation, HttpServletRequest request) {
        return new ApiResponsePayload<MotorVehicle>(publisher, payloadDescription, request.getRequestURL().append('?').append(request.getQueryString()).toString(), motorVehicleRepository.findMotorVehiclesByMakeAndModelAndGenerationContains(make, model, generation));
    }


}
