
public class Vector3D { 

    private double x,y,z;

    //constructor
    public Vector3D(){
        x=0.0;
        y=0.0;
        z=0.0;
    }
    public Vector3D(double x,double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    //getters
    public double getX(){ return this.x; }
    public double getY(){ return this.y; }
    public double getZ(){ return this.z; }

    @Override
    public String toString(){
        return String.format("(%f,%f,%f)",x,y,z);
    }

    //vector math ops
    public Double getMagnitude(){
        return Math.sqrt(x*x + y*y + z*z);
    }

    public Vector3D getNormalized(){
        double mag = this.getMagnitude();
        //both safe and makes sense, if the vector is zero length it should remain so.
        if (mag==0){
            return new Vector3D();
        }
        return new Vector3D(this.x/mag,this.y/mag,this.z/mag);
    }

    public Vector3D add(Vector3D other){
        return new Vector3D(this.x + other.x,this.y + other.y,this.z + other.z);
    }

    public Vector3D multiply(double other){
        return new Vector3D(this.x*other,this.y*other,this.z*other);
    }
    public double dotProduct(Vector3D other){
        return this.x*other.x + this.y*other.y + this.z*other.z;
    }
    public static double angleBetween(Vector3D a,Vector3D b){
        double dot  = a.getNormalized().dotProduct(b.getNormalized());
        if (dot < -1 || dot > 1){
            throw new IllegalStateException("Bad Arguments :(");
        }
        return Math.acos(dot);
    }
    public static Vector3D crossProduct(Vector3D a, Vector3D b){
        return new Vector3D(
            a.y*b.z - a.z*b.y,
            a.z*b.x - a.x*b.z,
            a.x*b.y - a.y*b.x
        );
    }
}

