
public class stok {
    private int id;
    private String musted;
    private String urun;
    private String adet;
    private String fiyat;

    public stok(int id, String musted, String urun, String adet, String fiyat) {
        this.id = id;
        this.musted = musted;
        this.urun = urun;
        this.adet = adet;
        this.fiyat = fiyat;
    }

  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMusted() {
        return musted;
    }

    public void setMusted(String musted) {
        this.musted = musted;
    }

    public String getUrun() {
        return urun;
    }

    public void setUrun(String urun) {
        this.urun = urun;
    }

    public String getAdet() {
        return adet;
    }

    public void setAdet(String adet) {
        this.adet = adet;
    }

    public String getFiyat() {
        return fiyat;
    }

    public void setFiyat(String fiyat) {
        this.fiyat = fiyat;
    }
    
    
    
}
