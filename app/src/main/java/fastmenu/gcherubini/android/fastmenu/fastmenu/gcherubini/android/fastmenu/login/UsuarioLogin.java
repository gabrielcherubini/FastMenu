package fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.login;

import fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.interfaces.QueryUsuarios;
import fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.superclasses.Usuario;

/**
 * Created by G.Cherubini on 11/08/2016.
 */
public class UsuarioLogin implements QueryUsuarios
{
    //Campos para pegar as informações dos editText do LoginFragment
    private String mEmailLogin;
    private String mSenhaLogin;

    //Construtor da classe
    public UsuarioLogin(String email, String senha)
    {
        mEmailLogin = email;
        mSenhaLogin = senha;
    }

    //Getters
    public String getEmailLogin()
    {
        return mEmailLogin;
    }
    public String getSenhaLogin()
    {
        return mSenhaLogin;
    }

    //Setters
    public void setEmailLogin(String emailLogin)
    {
        mEmailLogin = emailLogin;
    }

    public void setSenhaLogin(String senhaLogin)
    {
        mSenhaLogin = senhaLogin;
    }

    //Implementação dos métodos abstratos da interface QueryUsuarios definida. TODO: FALAR COM F. PINTO

    public String queryNome(String email)
    {
        String nome = "";

        return nome;
    }
    public String querySobrenome(String email)
    {
        String sobrenome = "";

        return sobrenome;
    }
    public String queryTelefone(String email)
    {
        String telefone = "";

        return telefone;
    }
    public String queryCPF(String email)
    {
        String CPF = "";

        return CPF;
    }
    public String querySenha(String email)
    {
        String senha = "";

        return senha;
    }


    //Método para verificar se o email informado está cadastrado na base de dados
    public boolean isUserRegistered()
    {
        boolean b = false;

        //TODO: Query para verificar se o usuário está registrado na base de dados (FALAR COM F. PINTO)

        return true; //DUMMY PARA TESTAR
    }

    //Método para buscar qual o usuário correspondente ao login informado
    public Usuario buscaUsuario()
    {
        //Cria nova instancia de "Usuário", buscando os dados de seus campos a partir do seu email na base de dados. TODO: FALAR COM F. PINTO
        return new Usuario(queryNome(getEmailLogin()), querySobrenome(getEmailLogin()), queryTelefone(getEmailLogin()),
                queryCPF(getEmailLogin()), getEmailLogin(), querySenha(getEmailLogin()));
    }


}
