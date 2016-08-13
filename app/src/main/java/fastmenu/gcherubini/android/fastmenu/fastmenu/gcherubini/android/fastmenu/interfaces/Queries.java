package fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.interfaces;

/**
 * Created by G.Cherubini on 11/08/2016.
 */
public interface Queries
{
    //Declaração de métodos abstratos para buscar valores correspondentes na base de dados  a partir do email
    String queryNome(String email);         //Busca nome do cliente na base de dados a partir do email
    String querySobrenome(String email);    //Busca sobrenome do cliente na base de dados a partir do email
    String queryTelefone(String email);     //Busca telefone do cliente na base de dados a partir do email
    String queryCPF(String email);          //Busca CPF do cliente na base de dados a partir do email
    String querySenha(String email);        //Busca senha do cliente na base de dados a partir do email
}
