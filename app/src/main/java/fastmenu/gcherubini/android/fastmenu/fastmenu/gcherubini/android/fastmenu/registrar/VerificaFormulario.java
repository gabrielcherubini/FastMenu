package fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.registrar;

import java.util.InputMismatchException;

import fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.superclasses.Mask;
import fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.superclasses.Usuario;

/**
 * Created by G.Cherubini on 26/08/2016.
 */
public class VerificaFormulario
{
    //Array de boolean para checar se há algum campo preenchido de forma errada
    protected static boolean[] fieldStatusErro = new boolean[5];

    //Array de boolean para checar se os campos estão vazios
    private static boolean[] isCampoNull = new boolean[7];

    //Constructor
    public VerificaFormulario() {}

    //Checa se todos os campos do formulário foram preenchidos
    protected static boolean isComplete(String[] fields)
    {
        boolean b = true;

        //Coloca TRUE em todos os campos do array de boolean (default: formulário está vazio)

        for (int i = 0; i < isCampoNull.length; i++)
        {
            isCampoNull[i] = true;
        }

        for (int i = 0; i < fields.length; i++)
        {
            if ((fields[i] != null) && (fields[i] != ""))
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

    protected static boolean isPasswordOk(String senha)
    {
        //TODO: escrever código para verificar se o password digitado é suficiente de acordo com o padrão mínimo exigido (falta definir padrão)
        return true; //dummy para testes
    }

    protected static boolean arePasswordsSame(String senha, String senha2)
    {
        if (senha.equals(senha2))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    protected static boolean isCPFOK(String cpfGrande)
    {
        boolean isCPF;
        char dig10, dig11;
        int sm, i, r, num, peso;
        String cpf = Mask.unmask(cpfGrande);

        if (cpf.equals("00000000000") || cpf.equals("11111111111") ||
                cpf.equals("22222222222") || cpf.equals("33333333333") ||
                cpf.equals("44444444444") || cpf.equals("55555555555") ||
                cpf.equals("66666666666") || cpf.equals("77777777777") ||
                cpf.equals("88888888888") || cpf.equals("99999999999") ||
                (cpf.length() != 11))
        {
            isCPF = false;
        }
        else
        {
            isCPF = true;
        }

        if (!isCPF)
        {
            return false;
        }
        else
        {
            // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
            try {
                // Calculo do 1o. Digito Verificador
                sm = 0;
                peso = 10;
                for (i = 0; i < 9; i++) {
                    // converte o i-esimo caractere do CPF em um numero:
                    // por exemplo, transforma o caractere '0' no inteiro 0
                    // (48 eh a posicao de '0' na tabela ASCII)
                    num = (int) (cpf.charAt(i) - 48);
                    sm = sm + (num * peso);
                    peso = peso - 1;
                }

                r = 11 - (sm % 11);

                if ((r == 10) || (r == 11)) {
                    dig10 = '0';
                } else {
                    dig10 = (char) (r + 48); // converte no respectivo caractere numerico
                }


                // Calculo do 2o. Digito Verificador
                sm = 0;
                peso = 11;
                for (i = 0; i < 10; i++) {
                    num = (int) (cpf.charAt(i) - 48);
                    sm = sm + (num * peso);
                    peso = peso - 1;
                }

                r = 11 - (sm % 11);
                if ((r == 10) || (r == 11)) {
                    dig11 = '0';
                } else {
                    dig11 = (char) (r + 48);
                }

                // Verifica se os digitos calculados conferem com os digitos informados.
                if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10))) {
                    return (true);
                } else {
                    return (false);
                }

            } catch (InputMismatchException erro) {
                return (false);
            }
        }
    }

    protected static boolean isCPFAvailable(String CPF)
    {
        //TODO: Escrever código da query do banco de dados para verificar se já há algum cadastro com o CPF indicado
        return true; //dummy para teste
    }

    protected static boolean isTelOK(String telefone)
    {
        String tel = Mask.unmask(telefone);
        return ((tel.length() == 10) || (tel.length() == 11));
    }

}
