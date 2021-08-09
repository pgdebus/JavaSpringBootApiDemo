package au.com.formis.springbootdemo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author      <a href="mailto:peter.debus@formis.com.au">Peter Debus</a>
 * @version     0.1
 *
 * <p>Interface for MotorVehicle CrudRepository to persist JPA data.</p>
 * <p></p>
 * <p>If there is a requirement to use batch operations and/or pagination
 * and sorting consider extending JpaRepository instead of CrudRepository.</p>
 * <p></p>
 * <p>This repository is used by a REST API to return MotorVehicle JSON data.
 * Currently JPA queries support the following entity fields (ie: MotorVehicle columns)</p>
 * <ul>
 *     <li>Make</li>
 *     <li>Make AND Model</li>
 *     <li>Make AND Model and Generation (case insensitive containing string, not equality)</li>
 * </ul>
 * <p>The above query fields map to equivalent query parameters for the REST API URL.</p>
 * <p>Examples</p>
 * <ul>
 *     <li>/motorVehicles?make=BMW</li>
 *     <li>/motorVehicles?make=BMW&model=3-Series</li>
 *     <li>/motorVehicles?make=BMW&model=3-Series&generation=conVERtible</li>
 * </ul>
 * <p>
 * The MotorVehicle repository is used by the MotorVehicleController to return REST API JSON
 * data for a given request.</p>
 * <p></p>
 * <p>
 * @see org.springframework.stereotype.Repository
 * @see org.springframework.data.repository.CrudRepository
 * @see org.springframework.data.jpa.repository.Query
 * @see <a href="https://docs.oracle.com/html/E13946_04/ejb3_langref.html">https://docs.oracle.com/html/E13946_04/ejb3_langref.html</a>
 * @since       0.1
 * </p>
 */
@Repository
public interface MotorVehicleRepository extends CrudRepository<MotorVehicle, Long> {
    /**
     * <p>Query select data using the Make field/column only.</p>
     * @param make Make of motor vehicle
     * @return Returns a List of MotorVehicle entities matching the JPQL query.
     */
    List<MotorVehicle> findMotorVehiclesByMake(String make);

    /**
     * <p>Query select data using the Make AND Model fields/columns.</p>
     * @param make Make of motor vehicle
     * @param model Model of motor vehicle
     * @return Returns a List of MotorVehicle entities matching the JPQL query.
     */
    List<MotorVehicle> findMotorVehiclesByMakeAndModel(String make, String model);

    /**
     * <p>Query select data using the Make AND Model AND Generation fields/columns.
     * The select uses a case insensitive query for the generation column using a contains (ie: like)
     * match not equality.</p>
     * @param make Make of motor vehicle
     * @param model Model of motor vehicle
     * @param generation Generation of motor vehicle
     * @return Returns a List of MotorVehicle entities matching the JPQL query.
     */
    @Query("select c from MotorVehicle c where c.make = ?1 and c.model = ?2 and lower(c.generation) like lower(concat('%', ?3, '%'))")
    List<MotorVehicle> findMotorVehiclesByMakeAndModelAndGenerationContains(String make, String model, String generation);

}
