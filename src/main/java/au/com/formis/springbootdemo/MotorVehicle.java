package au.com.formis.springbootdemo;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author      <a href="mailto:peter.debus@formis.com.au">Peter Debus</a>
 * @version     0.1
 *
 *
 * <p>An entity POJO that represents a motor vehicle that will be persisted in a database
 * table called motorvehicle.</p>
 * <p></p>
 * <p>This entity is persisted via a CrudRepository and JPQL queries.
 * Note the @Table annotation in the code to force MotorVehicle to be mapped to MOTORVEHICLE in the
 * RDBMS instead of MOTOR_VEHICLE.</p>
 * <p></p>
 * <p>
 * The table PK ID column is auto incremented using the database for inserts
 * (ie: @GeneratedValue(strategy = GenerationType.IDENTITY).
 * Optimisation tip : Using @GeneratedValue(strategy = GenerationType.IDENTITY) means
 * Hibernate must do an insert immediately to get primary key value which prevents optimisations
 * like JDBC batching.This is a demo so this approach  will suffice for now.
 * Using GenerationType.SEQUENCE allows Hibernate to decide when to do inserts for optimal performance,
 * for example when doing batch inserts.
 * </p>
 * <p>
 * @see javax.persistence.Entity
 * @see javax.persistence.Id
 * @see javax.persistence.GeneratedValue
 * @see <a href="https://www.baeldung.com/hibernate-identifiers">https://www.baeldung.com/hibernate-identifiers</a>
 * @since       0.1
 * </p>
 */
@Entity
@Table(name = "motorvehicle")
public class MotorVehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String make;
    private String model;
    private String generation;
    private String trimVersion;
    private String dateFrom;
    private String dateTo;
    private String newPrice;
    private int power;
    private int torque;
    private int fuelCapacity;
    private int engineSize;
    private int cylinders;
    private int valves;
    private String fuelType;
    private String transmission;
    private String gearbox;
    private String country;

    /**
     * MotorVehicle constructor.
     * @param id            PK id sequence field, auto increment in RDBMS.
     * @param make          Make of vehicle, example "Toyota"
     * @param model         Model, example Prius
     * @param generation    Generation of vehicle, example  Plus 2012 Specs
     * @param trimVersion   Trim version, example 1.8 VVTi Icon (Nav) (01/15-) 5d CVT Auto
     * @param dateFrom      Start date when vehicle was manufactured
     * @param dateTo        End date when vehicle was manufactured
     * @param newPrice      Price when new
     * @param power         Power in bhp
     * @param torque        Torque in Nm
     * @param fuelCapacity  Fuel capacity in litres
     * @param engineSize    Engin esize in cubic cm (cc)
     * @param cylinders     Number ofengine  cylinders
     * @param valves        Number of engine valves
     * @param fuelType      Fuel type, example Petrol/Electric Hybrid or Diesel
     * @param transmission  Transmission type, example Manual or Automatic
     * @param gearbox       Gearbox type, example 8 Speed Step Auto
     * @param country       Country of origin
     */
    public MotorVehicle(Long id, String make, String model, String generation, String trimVersion, String dateFrom, String dateTo, String newPrice, int power, int torque, int fuelCapacity, int engineSize, int cylinders, int valves, String fuelType, String transmission, String gearbox, String country) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.generation = generation;
        this.trimVersion = trimVersion;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.newPrice = newPrice;
        this.power = power;
        this.torque = torque;
        this.fuelCapacity = fuelCapacity;
        this.engineSize = engineSize;
        this.cylinders = cylinders;
        this.valves = valves;
        this.fuelType = fuelType;
        this.transmission = transmission;
        this.gearbox = gearbox;
        this.country = country;
    }

    /**
     * <p>The JPA specification requires that all persistent classes have a no-arg constructor.</p>
     */
    public MotorVehicle() {

    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }

    public String getTrimVersion() {
        return trimVersion;
    }

    public void setTrimVersion(String trimVersion) {
        this.trimVersion = trimVersion;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public String getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(String newPrice) {
        this.newPrice = newPrice;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getTorque() {
        return torque;
    }

    public void setTorque(int torque) {
        this.torque = torque;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public int getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(int engineSize) {
        this.engineSize = engineSize;
    }

    public int getCylinders() {
        return cylinders;
    }

    public void setCylinders(int cylinders) {
        this.cylinders = cylinders;
    }

    public int getValves() {
        return valves;
    }

    public void setValves(int valves) {
        this.valves = valves;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "MotorVehicle{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", generation='" + generation + '\'' +
                ", trimVersion='" + trimVersion + '\'' +
                ", dateFrom='" + dateFrom + '\'' +
                ", dateTo='" + dateTo + '\'' +
                ", newPrice='" + newPrice + '\'' +
                ", power=" + power +
                ", torque=" + torque +
                ", fuelCapacity=" + fuelCapacity +
                ", engineSize=" + engineSize +
                ", cylinders=" + cylinders +
                ", valves=" + valves +
                ", fuelType='" + fuelType + '\'' +
                ", transmission='" + transmission + '\'' +
                ", gearbox='" + gearbox + '\'' +
                ", country='" + country + '\'' +
                '}';
    }


}
