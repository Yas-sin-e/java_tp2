public class point {
    private int abs;
    private int ord;
    private String nom;
    
    public point(int abs, int ord, String nom) {
        this.abs = abs;
        this.ord = ord;
        this.nom = nom;
    }
    public point (){
        this.abs = 0;
        this.ord = 0;
        this.nom = "A";

    }
    public void afficher(){
        System.out.println("Le point "+this.nom+" a pour coordonnees : ("+this.abs+","+this.ord+")");
    }
    public int distance(point p){
      return (int) Math.sqrt(Math.pow((this.abs - p.abs),2) + Math.pow((this.ord - p.ord),2));
    }
    public int getAbs(){
      return this.abs;
    } 
    public int getOrd(){
      return this.ord;
    }
    public String getNom(){
      return this.nom;
    }
    public void setAbs(int abs){
      this.abs=abs;
    }
    public void setOrd(int ord){
      this.ord=ord;
    }
    public void setNom(String nom){
      this.nom=nom;
    }
    

}
