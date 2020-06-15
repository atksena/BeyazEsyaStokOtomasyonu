
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;




public class stokislemleri {
    private Connection con=null;
    private Statement st=null;
    private PreparedStatement ps= null;
    
     public stokislemleri(){
        
   
        String url = "jdbc:mysql://"+baglanti.host+":"+baglanti.port+"/"+baglanti.vb_ismi;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(stokislemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con = DriverManager.getConnection(url,baglanti.kullanici_adi,baglanti.parola);
        } catch (SQLException ex) {
            Logger.getLogger(stokislemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

     public void urunusil(int id){
         
         String sorgu = "DELETE FROM stoklar WHERE id=?";
         
        try {
            ps=con.prepareStatement(sorgu);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(stokislemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
     }
     
    public void urunguncelle (int id, String yeni_musted, String yeni_urun, String yeni_adet, String yeni_fiyat){
        
        String sorgu = "UPDATE stoklar SET musted=?,urun=?,adet=?,fiyat=? WHERE id=?";
        
        try {
            ps=con.prepareStatement(sorgu);
            
            ps.setString(1, yeni_musted);
            ps.setString(2, yeni_urun);
            ps.setString(3, yeni_adet);
            ps.setString(4, yeni_fiyat);
            
            ps.setInt(5, id);
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(stokislemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
     public void urunekle(String musted,String urun, String adet, String fiyat){
        
        String sorgu = "INSERT INTO stoklar (musted,urun,adet,fiyat) VALUES (?,?,?,?)";
        
        try {
            ps = con.prepareStatement(sorgu);
            
            ps.setString(1, musted);
            ps.setString(2, urun);
            ps.setString(3, adet);
            ps.setString(4, fiyat);
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(stokislemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 public ArrayList <stok> stokgoruntule (){
        ArrayList<stok> cikti = new ArrayList<stok>();
        try {
            st = con.createStatement();
            String sorgu = "SELECT * FROM stoklar";
            ResultSet rs = st.executeQuery(sorgu);
            
            while(rs.next()){
                int id = rs.getInt("id");
                String musted =rs.getString("musted");
                String urun =rs.getString("urun");
                String adet = rs.getString("adet");
                String fiyat = rs.getString("fiyat");
                 cikti.add(new stok(id, musted,urun,adet,fiyat));
                
                             
            }
            return cikti;
        } catch (SQLException ex) {
            Logger.getLogger(stokislemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        
    }
    
    public boolean girisyap (String kullanici_adi,String parola){
        
        String sorgu = "SELECT * FROM kullanici_girisi WHERE username=? AND password=?";
        
        try {
            ps= con.prepareStatement(sorgu);
            ps.setString(1, kullanici_adi);
            ps.setString(2, parola);
            
            ResultSet rs = ps.executeQuery();
            
            return rs.next();
            
        } catch (SQLException ex) {
            Logger.getLogger(stokislemleri.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }  

   
}  
        
    
   

  


