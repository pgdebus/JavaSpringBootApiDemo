package au.com.formis.springbootdemo;

import java.util.List;


/**
 * @author      <a href="mailto:peter.debus@formis.com.au">Peter Debus</a>
 * @version     0.1
 *
 * @param <T> Entity type to return API in response payload, in this example it is MotorVehicle.
 *
 * <p></p>
 * <p>A REST API payload class to aggregate some response metadata with a list
 * of entities returned by the API query. In this example demo it is MotorVehicle.</p>
 * <p></p>
 * <p>The class uses generic &lt;T&gt; type to support a List of any entity type.</p>
 * <p></p>
 * <p>
 * @since       0.1
 * </p>
 */
public class ApiResponsePayload<T> {

    private final String publisher;
    private final String payloadDescription;
    private final String payloadURL;
    private final int numberOfRecords;
    private final List<T> payload;

    /**
     * <p>ApiResponsePayload constructor. Fetches the size of the List of entities and adds a
     * number of records metadata value to the API response payload.</p>
     * <p></p>
     * @param publisher Payload publisher metadata.
     * @param payloadDescription Payload description metadata.
     * @param payloadURL Payload request URL metadata.
     * @param payload List of payload entities of type &lt;T&gt;
     */
    public ApiResponsePayload(String publisher, String payloadDescription, String payloadURL, List<T> payload) {
        this.publisher = publisher;
        this.payloadDescription = payloadDescription;
        this.payloadURL = payloadURL;
        this.payload = payload;
        this.numberOfRecords = (this.payload == null) ? 0 : this.payload.size();
    }

    public String getPublisher() {
        return publisher;
    }

    public String getPayloadDescription() {
        return payloadDescription;
    }

    public String getPayloadURL() {
        return payloadURL;
    }

    public int getNumberOfRecords() {
        return numberOfRecords;
    }

    public List<T> getPayload() {
        return payload;
    }
}
