package fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.registrar;

import fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.superclasses.Usuario;

/**
 * Created by G.Cherubini on 26/08/2016.
 */

//TODO: Classe que vai fazer a conexão com a base de dados para registrar o novo usuário
public class RegistrarUsuario
{
    private Usuario mUsuario;

    public RegistrarUsuario(Usuario usuario)
    {
        setUsuario(usuario);
    }
    public void setUsuario(Usuario usuario)
    {
        mUsuario = usuario;
    }

    private String encriptarSenha()
    {
        return "";
    }


    private void registrarUsuarioDB()
    {

    }
}
