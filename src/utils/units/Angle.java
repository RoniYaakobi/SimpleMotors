package simplemotor.utils.units;


public class Angle {

    /**
     *     These angle conversions work by multiplying by the value you want to convert
     *     If you want to convert the opposite way around (eg: degrees to radians
     *     and not radians to degrees) you divide instead.
     */
    public static double ROTATIONS_TO_RADIANS = Math.PI * 2;
    public static double ROTATIONS_TO_DEGREES = 360;
    public static double RADIANS_TO_DEGREES = ROTATIONS_TO_DEGREES / ROTATIONS_TO_RADIANS;

    public static Angle kZero = new Angle();

    private double m_radians;
    private double m_cos;
    private double m_sin;

    /**
     * @param radians of the angle
     */
    public Angle(double radians){
        m_radians = radians;
        m_cos = Math.cos(m_radians);
        m_sin = Math.sin(m_radians);
    }

    /**
     * Create a 0 Angle object
     */
    public Angle(){
        m_radians = 0.0;
        m_cos = 1.0;
        m_sin = 0.0;
    }

    /**
     * @param x the component in front of the angle
     * @param y the component next to the angle
     */
    public Angle(double x, double y) {
        double magnitude = Math.hypot(x,y);

        if (magnitude < 1e-6){
            m_cos = 1.0;
            m_sin = 0.0;

        } else {
            m_cos = x / magnitude;
            m_sin = y / magnitude;
        }
        m_radians = Math.atan2(m_sin, m_cos);
    }

    /**
     * Factory for making {@code Angle} objects from rotation units
     * @param rotation which represents the angle
     * @return An {@code Angle} object representing the angle
     */
    public static Angle fromRotations(double rotation){
        return new Angle(rotation * ROTATIONS_TO_RADIANS);
    }

    /**
     * Factory for making {@code Angle} objects from degrees units
     * @param degrees which represents the angle
     * @return An {@code Angle} object representing the angle
     */
    public static Angle fromDegrees(double degrees){
        return new Angle(degrees / RADIANS_TO_DEGREES);
    }

    /**
     * Factory for making {@code Angle} objects from radians units
     * @param radians which represents the angle
     * @return An {@code Angle} object representing the angle
     */
    public static Angle fromRadians(double radians){
        return new Angle(radians);
    }

    /**
     * @return The angle in rotation units
     */
    public double getRotations(){
        return m_radians / ROTATIONS_TO_RADIANS;
    }

    /**
     * @return The angle in degrees units
     */
    public double getDegrees(){
        return m_radians * RADIANS_TO_DEGREES;
    }

    /**
     * @return The angle in radians units
     */
    public double getRadians(){
        return m_radians;
    }


    /**
     * Rotate this angle by another angle
     * @param other angle to rotate this angle by
     * @return a rotated {@code Angle}
     */
    public Angle rotateBy(Angle other)  {
        /**
         * The matrix to rotate a vector by theta looks like this:
         * |x| [ cos(theta), -sin(theta)] -> | x * cos(theta) - sin(theta) * y |
         * |y| [ sin(theta), cos(theta)] -> | x * sin(theta) + cos(theta) * y |
         */
        return new Angle(
                m_cos * other.m_cos - m_sin * other.m_sin,
                m_cos * other.m_sin + m_sin * other.m_cos
        );

    }

    /**
     * add an angle to this one
     * @param other the angle to add to this one
     * @return an {@code Angle} of the sum of this and {@code other}
     */
    public Angle add(Angle other) {
        return this.rotateBy(other);
    }

    /**
     * @return an {@code Angle} which has this angle counterclockwise instead of clockwise
     */
    public Angle unaryMinus(){
        return new Angle(-m_radians);
    }

    /**
     * subtract an angle from this one
     * @param other the angle to subtract from this one
     * @return an {@code Angle} of the subtraction of {@code other} from this
     */
    public Angle sub(Angle other){
        return this.rotateBy(other.unaryMinus());
    }
}
