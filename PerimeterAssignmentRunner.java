import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner 
{
    //this method returns the perimeter of the shape
    public double getPerimeter (Shape s) 
    {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) 
        {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }
    
    //This method returns an integer that is the number of points in Shape s
    public int getNumPoints (Shape s) 
    {
        int numberOfPoints = 0;
        for( Point n : s.getPoints())
        {
            numberOfPoints+=1;
        }
        return numberOfPoints;
    }

    //This method returns a number of type double 
    //that is the calculated average of all the sides’ lengths in the Shape S
    public double getAverageLength(Shape s) 
    {
        double length = getPerimeter(s);
        double side = getNumPoints(s);
        double averageLength = length / side; 
        return averageLength;
    }

    //This method returns a number of type double 
    //that is the longest side in the Shape S
    public double getLargestSide(Shape s) 
    {
        Point lastPoint = s.getLastPoint();
        double longestSide = 0.0;
        for( Point n : s.getPoints())
        {
            double distance = lastPoint.distance(n);
            if(distance > longestSide)
            {
                longestSide = distance;
            }
            lastPoint = n;
        }
        return longestSide;
    }

    //This method returns a number of type double 
    //that is the largest x value over all the points in the Shape s.
    public double getLargestX(Shape s) 
    {
        Point lastPoint = s.getLastPoint();
        double lastPointx = lastPoint.getX();
        double largestX = lastPointx;
        for(Point n : s.getPoints())
        {
            double newX = n.getX();
            if(newX > largestX)
                largestX = newX;
        }
        return largestX;
    }

    //This method creates a DirectoryResource so you can select multiple files
    //and then iterates over these files.
    public double getLargestPerimeterMultipleFiles() 
    {
        DirectoryResource direc = new DirectoryResource();
        double largestPerimeter = 0.0;
        FileResource largestFile = null;
        for( File f : direc.selectedFiles())
        {
            FileResource file = new FileResource(f);
            Shape h = new Shape(file);
            double perimeter = getPerimeter(h);
            if(perimeter > largestPerimeter)
                largestPerimeter = perimeter;
        }
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() 
    {
        DirectoryResource direc = new DirectoryResource();
        double largestPerimeter = 0.0;
        File largestFile = null;
        for(File f: direc.selectedFiles())
        {
            FileResource file = new FileResource(f);
            Shape h = new Shape(file);
            double perimeter = getPerimeter(h);
            if(perimeter> largestPerimeter)
            {
                largestFile = f;
                largestPerimeter = perimeter;
            }
        }
        
        return largestFile.getName();
    }

    public void testPerimeter () 
    {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int numberOfPoints = getNumPoints(s);
        double averageLength = getAverageLength(s);
        double longestSide = getLargestSide(s);
        double largestX = getLargestX(s);
        
        
        System.out.println("perimeter = " + length);
        System.out.println("numpoints = " + numberOfPoints);
        System.out.println("averagelen = " + averageLength);
        System.out.println("longest side = " + longestSide);
        System.out.println("largestX = " + largestX);
    }
    
    public void testPerimeterMultipleFiles() 
    {
        double largestperim = getLargestPerimeterMultipleFiles();
        System.out.println("Largest file is " + largestperim);
    }

    public void testFileWithLargestPerimeter() 
    {
        String file = getFileWithLargestPerimeter();
        System.out.println("Largest perimeter file is " + file);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints())
        {
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+ peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() 
    {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) 
        {
            System.out.println(f);
        }
    }

    public static void main (String[] args) 
    {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
       
    }
}
