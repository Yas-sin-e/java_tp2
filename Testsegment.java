
public class Testsegment {
  public static void main (String[]args){
    // cration des point :
    point p1=new point(0,0,"A");
    point p2=new point(3,4,"B");
    point p3=new point(1,1,"C");
    
    Segment s1=new Segment(p1,p2);
  
  
  System.out.println("segment s1 :"+s1);
  System.out.println("longeur de s1 :"+s1.longeur());
  System.out.println("le point C appartient il au segment s1 ? :"+s1.appartient(p3));
  s1.translater(2, 1) ;
    System.out.println("apres translation de s1 de (2,1) :"+s1);

} 
}
