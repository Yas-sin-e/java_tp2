public class Segment {
  private point extr1;
  private point extr2;
  

  public Segment (point extr1 , point extr2){
    this.extr1=extr1;
    this.extr2=extr2;
  }
  public Segment (){
    this.extr1=new point();
    this.extr2=new point(1,1,"b");

  }
  @Override
  public String toString(){
    return "[ "+ extr1.getNom()+"("+ extr1.getAbs()+","+extr1.getOrd()+")" +
    ","+ extr2.getNom()+"("+ extr2.getAbs()+","+extr2.getOrd()+") ]";
  }
  public int longeur (){
    return extr1.distance(extr2);
  }
  public boolean appartient(point p){
    return (extr1.distance(p)+extr2.distance(p)==this.longeur());
  }
  public void translater (int dx , int dy){
    extr1.setAbs(dy+extr1.getAbs());
    extr1.setOrd(dx+extr1.getOrd());
    extr2.setAbs(dy+extr2.getAbs());
    extr2.setOrd(dx+extr2.getOrd());

  }
  public point getExtr1(){
    return this.extr1;
  }
  public point getextr1(){
    return this.extr1;
  }

  public point getextr2(){
    return this.extr2;
  }
}
