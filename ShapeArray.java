public class ShapeArray {

    public static void main(String[] args) {

        
        Sphere sphere = new Sphere(5);

        Cylinder cylinder =
                new Cylinder(4, 8);

        Cone cone =
                new Cone(3, 7);

        
        Shape[] shapeArray =
                {sphere, cylinder, cone};

       
        for (Shape shape : shapeArray) {

            System.out.println(shape.toString());
        }
    }
}

