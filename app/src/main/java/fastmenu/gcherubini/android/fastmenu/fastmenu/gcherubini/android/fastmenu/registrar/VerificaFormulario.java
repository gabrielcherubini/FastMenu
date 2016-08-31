package fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.registrar;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.j

import fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.superclasses.Usuario;

/**
 * Created by G.Cherubini on 26/08/2016.
 */
public class VerificaFormulario
{
    //Instancia de "Usuário" criada ao clicar o botão de registro
    private Usuario mUsuario;

    //Senha 2 do formulário
    private String mSenha2;


    //Array de boolean para checar se os campos estão vazios
    private boolean[] isCampoNull = new boolean[7];

    //Constructor
    public VerificaFormulario(Usuario usuario, String senha2)
    {
        setUsuario(usuario);
        setSenha2(senha2);
    }

    public void setUsuario(Usuario usuario)
    {
        mUsuario = usuario;
    }

    public void setSenha2(String senha2)
    {
        mSenha2 = senha2;
    }

    //Coloca TRUE em todos os campos do array de boolean (default: formulário está vazio)
    private void setTrue()
    {
        for (int i = 0; i < isCampoNull.length; i++)
        {
            isCampoNull[i] = true;
        }
    }

    //Checa se todos os campos do formulário foram preenchidos
    protected boolean isComplete()
    {
        boolean b = true;
        String[] camposAux = {mUsuario.getNome(), mUsuario.getSobrenome(), mUsuario.getTelefone(), mUsuario.getCPF(), mUsuario.getEmail(), mUsuario.getSenha(), mSenha2};

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

    protected boolean isPasswordOk()
    {
        //TODO: escrever código para verificar se o password digitado é suficiente de acordo com o padrão mínimo exigido (falta definir padrão)
        return true; //dummy para testes
    }

    protected boolean arePasswordsSame()
    {
        if (mUsuario.getSenha().equals(mSenha2))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    protected boolean isCPF()
    {
        // considera-se erro CPFs formados por uma sequencia de numeros iguais
        if (mUsuario.getCPF().equals("00000000000") || mUsuario.getCPF().equals("11111111111") ||
                mUsuario.getCPF().equals("22222222222") || mUsuario.getCPF().equals("33333333333") ||
                mUsuario.getCPF().equals("44444444444") || mUsuario.getCPF().equals("55555555555") ||
                mUsuario.getCPF().equals("66666666666") || mUsuario.getCPF().equals("77777777777") ||
                mUsuario.getCPF().equals("88888888888") || mUsuario.getCPF().equals("99999999999") ||
                (mUsuario.getCPF().length() != 11))
        {
            return false;
        }
        else
        {
            return true;
        }

    }

    protected boolean isCPFOK()
    {
        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try
        {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++)
            {
                // converte o i-esimo caractere do CPF em um numero:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posicao de '0' na tabela ASCII)
                num = (int) (mUsuario.getCPF().charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);

            if ((r == 10) || (r == 11))
            {
                dig10 = '0';
            } else
            {
                dig10 = (char) (r + 48); // converte no respectivo caractere numerico
            }


            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++)
            {
                num = (int) (mUsuario.getCPF().charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
            {
                dig11 = '0';
            }
            else
            {
                dig11 = (char) (r + 48);
            }

            // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == mUsuario.getCPF().charAt(9)) && (dig11 == mUsuario.getCPF().charAt(10)))
            {
                return (true);
            }
            else
            {
                return (false);
            }

        }
        catch (InputMismatchException erro)
        {
            return (false);
        }
    }

    protected boolean isCPFAvailable()
    {
        //TODO: Escrever código da query do banco de dados para verificar se já há algum cadastro com o CPF indicado
        return true; //dummy para teste
    }

    protected String formatarTelefone()
    {
        String numTel;
        try {
            MaskFormatter phoneFormatter = new MaskFormatter("(##) #####-####");
            JFormattedTextField txtPhone = new JFormattedTextField(phoneFormatter);
            txtPhone.setText(phone);
            return
        } catch (ParseException e) {
            e.printStackTrace();
            return;
        }
        mUsuario.getTelefone()
    }



}
