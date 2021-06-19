import dao.AutorDao;
import dao.CartiDao;
import dao.ClientiDao;
import dao.ImprumutDao;
import model.*;

import java.util.List;


//  cartiDao, select cu join
// delete by Id pt carti, InsertById pt carti
// clientiDao: FindById, Insert, delete
// imprumutDao: inserere imprumut nou, metoda pt afisarea imprumuturilor pt care cartile nu au fost returnate (+ inner join)

public class BibliotecaMain {

    public static void main(String[] args) {

        AutorDao autorDao = new AutorDao();
        CartiDao cartiDao = new CartiDao();
        ClientiDao clientiDao = new ClientiDao();
        ImprumutDao imprumutDao = new ImprumutDao();

//        Autor autor = autorDao.findById(7);
//        System.out.println(autor);

//        Autor autor1 = new Autor();
//        autor1.setNume("Juban");
//        autor1.setPrenume("Marin");
//        autorDao.save(autor1);

//        List<Autor> autors = autorDao.getAll();
//        System.out.println(autors);

//        autorDao.deleteById(15);

//
//Carti carti = cartiDao.findById(38);
//System.out.println(carti);

          Carti carti1 = new Carti();
          carti1.setDenumire("Albatros");
          carti1.setEditura("Litera");
          carti1.setAnAparitie("2011-02-23");
          carti1.setAutor(new Autor(5));
          carti1.setGenuri(new Genuri(1));
          cartiDao.save(carti1);


//        List<Carti> cartis = cartiDao.getAll();
//        System.out.println(cartis);

//        cartiDao.deleteById(47);


//        Clienti clienti = clientiDao.findById(14);
//        System.out.println(clienti);

//        Clienti client1 = new Clienti();
//        client1.setNume("Jiji");
//        client1.setPrenume("Marin");
//        client1.setTelefon("0739206386");
//        client1.setEmail("marinjiji@email.ro");
//        client1.setAdresa("Strada Adresei, nr. 2");
//        clientiDao.save(client1);
//
//
//        clientiDao.deleteById(15);



//        Imprumut imprumut = imprumutDao.findById(2);
//        System.out.println(imprumut);

//        List<Imprumut> imprumuts = imprumutDao.getAll();
//        System.out.println(imprumuts);


//        Imprumut imprumut1 = new Imprumut();
//        imprumut1.setDataImprumut("2020-03-03");


//        autorDao.save(null);
    }

}
