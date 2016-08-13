package fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.superclasses;

/**
 * Created by G.Cherubini on 10/08/2016.
 */
public class Usuario {

    // Campos que um usuário deve fornecer
    protected String mNome;
    protected String mSobrenome;
    protected String mTelefone;
    protected String mCPF;
    protected String mEmail;
    protected String mSenha1;
    protected String mSenha2;


    //Construtor
    public Usuario(String nome, String sobrenome, String telefone, String CPF, String email, String senha1, String senha2)
    {
        setNome(nome);
        setSobrenome(sobrenome);
        setTelefone(telefone);
        setCPF(CPF);
        setEmail(email);
        setSenha1(senha1);
        setSenha2(senha2);
    }

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

    public void setSenha1(String senha1) {
        mSenha1 = senha1;
    }

    public void setSenha2(String senha2) {
        mSenha2 = senha2;
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

    public String getSenha1()
    {
        return mSenha1;
    }

    public String getSenha2()
    {
        return mSenha2;
    }
}

//TODO: Escrever classes/campos adicionais para método de pagamento e histórico da conta
