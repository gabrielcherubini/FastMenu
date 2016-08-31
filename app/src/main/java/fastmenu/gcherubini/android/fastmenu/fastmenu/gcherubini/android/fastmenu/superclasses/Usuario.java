package fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.superclasses;

/**
 * Created by G.Cherubini on 10/08/2016.
 */
public class Usuario
{
    // Campos que um usuário deve fornecer
    protected String mNome;
    protected String mSobrenome;
    protected String mTelefone;
    protected String mCPF;
    protected String mEmail;
    protected String mSenha;

    //Construtor
    public Usuario(String nome, String sobrenome, String telefone, String CPF, String email, String senha)
    {
        setNome(nome);
        setSobrenome(sobrenome);
        setTelefone(telefone);
        setCPF(CPF);
        setEmail(email);
        setSenha(senha);
    }

    public Usuario(){}

    // Setters
    public void setNome(String nome) {
        mNome = nome;
    }

    public void setSobrenome(String sobrenome) {
        mSobrenome = sobrenome;
    }

    public void setTelefone(String telefone) {
        mTelefone = telefone;
    }

    public void setCPF(String CPF) {
        mCPF = CPF;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public void setSenha(String senha) {
        mSenha = senha;
    }


    // Getters
    public String getNome()
    {
        return mNome;
    }

    public String getSobrenome()
    {
        return mSobrenome;
    }

    public String getTelefone()
    {
        return mTelefone;
    }

    public String getCPF()
    {
        return mCPF;
    }

    public String getEmail()
    {
        return mEmail;
    }

    public String getSenha()
    {
        return mSenha;
    }
}
