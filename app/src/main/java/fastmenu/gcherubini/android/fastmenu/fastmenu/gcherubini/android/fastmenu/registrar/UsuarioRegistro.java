package fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.registrar;

import fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.superclasses.Usuario;

/**
 * Created by G.Cherubini on 10/08/2016.
 */
public class UsuarioRegistro extends Usuario
{

    private boolean[] isCampoNull = new boolean[7];

    private void setTrue()
    {
        for (int i = 0; i < isCampoNull.length; i++)
        {
            isCampoNull[i] = true;
        }
    }

    //Construtor
    public UsuarioRegistro(String nome, String sobrenome, String telefone, String CPF, String email, String senha1, String senha2)
    {
        super(nome, sobrenome, telefone, CPF, email, senha1, senha2);
    }

    protected boolean isComplete()
    {
        boolean b = true;
        String[] camposAux = {mNome, mSobrenome, mTelefone, mCPF, mEmail, mSenha1, mSenha2};

        setTrue();

        for (int i = 0; i < camposAux.length; i++)
        {
            if (camposAux[i] != null)
            {
                isCampoNull[i] = false;
            }
        }

        for (boolean s : isCampoNull)
        {
            if (s)
            {
                b = false;
            }
        }
        return b;
    }

    protected boolean isCPFok ()
    {
        //TODO: Escrever código da query do banco de dados para verificar se já há algum cadastro com o CPF indicado
        return true; //dummy para teste
    }

    protected boolean arePasswordsSame()
    {
        if (mSenha1.equals(mSenha2))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    protected boolean isPasswordOk()
    {
        //TODO: escrever código para verificar se o password digitado é suficiente de acordo com o padrão mínimo exigido (falta definir padrão)
        return true; //dummy para testes
    }

    protected void registrarUsuarioDB()
    {

    }

}
