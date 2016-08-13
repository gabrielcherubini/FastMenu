package fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.registrar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import fastmenu.gcherubini.android.fastmenu.R;

/**
 * Created by G.Cherubini on 09/08/2016.
 */
public class RegistrarFragment extends Fragment
{
    //Declaração dos widgets do fragment
    private Button mRegistrarButtonRegistrar;
    protected EditText mNomeEditTextRegistrar;
    protected EditText mSobrenomeEditTextRegistrar;
    protected EditText mTelefoneEditTextRegistrar;
    protected EditText mCPFEditTextRegistrar;
    protected EditText mEmailEditTextRegistrar;
    protected EditText mSenha1EditTextRegistrar;
    protected EditText mSenha2EditTextRegistrar;

    //Declaração da variável para comportar a classe de registro de novo usuário
    private UsuarioRegistro usuarioRegistro;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_registrar, container, false);

        //Definindo as referências
        mNomeEditTextRegistrar = (EditText)v.findViewById(R.id.nomeRegistrar_editText);
        mSobrenomeEditTextRegistrar = (EditText)v.findViewById(R.id.sobrenomeRegistrar_editText);
        mTelefoneEditTextRegistrar = (EditText)v.findViewById(R.id.telefoneRegistrar_editText);
        mCPFEditTextRegistrar = (EditText)v.findViewById(R.id.cpfRegistrar_editText);
        mEmailEditTextRegistrar = (EditText)v.findViewById(R.id.emailRegistrar_editText);
        mSenha1EditTextRegistrar = (EditText)v.findViewById(R.id.senha1Registrar_editText);
        mSenha2EditTextRegistrar = (EditText)v.findViewById(R.id.senha2Registrar_editText);

        //Deixando o valor inicial das strings como null
        mNomeEditTextRegistrar.setText(null);
        mSobrenomeEditTextRegistrar.setText(null);
        mTelefoneEditTextRegistrar.setText(null);
        mCPFEditTextRegistrar.setText(null);
        mEmailEditTextRegistrar.setText(null);
        mSenha1EditTextRegistrar.setText(null);
        mSenha2EditTextRegistrar.setText(null);

        //Click Listener no botão "Registrar"
        mRegistrarButtonRegistrar = (Button)v.findViewById(R.id.registrarRegistrar_button);
        mRegistrarButtonRegistrar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                //Inicializando classe para registro dos usuários
                usuarioRegistro = new UsuarioRegistro(mNomeEditTextRegistrar.getText().toString(),mSobrenomeEditTextRegistrar.getText().toString(),
                        mTelefoneEditTextRegistrar.getText().toString(),mCPFEditTextRegistrar.getText().toString(),mEmailEditTextRegistrar.getText().toString(),
                        mSenha1EditTextRegistrar.getText().toString(),mSenha2EditTextRegistrar.getText().toString());

                //Chama método para verificar se todos os campos foram preenchidos
                if (usuarioRegistro.isComplete())
                {
                    //Chama método para verificar se o CPF informado já foi registrado
                    if (usuarioRegistro.isCPFok())
                    {
                        //Chama método para verificar se o formato adotado para a senha está correto
                        if (usuarioRegistro.isPasswordOk())
                        {
                            //Chama método para verificar se a senha e a verificação estão iguais
                            if (usuarioRegistro.arePasswordsSame())
                            {
                                //Se estão iguais, chama método para registrar um novo usuário na base de dados TODO: CONVERSAR COM F. Pinto
                                usuarioRegistro.registrarUsuarioDB();
                            }
                            else
                            {
                                //Toast para avisar que as senhas informadas diferem
                                Toast.makeText(getActivity(), R.string.senhaDiferenteToast_string, Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            //Toast para avisar que o formato adotado é insuficiente
                            Toast.makeText(getActivity(), R.string.senhaInvalidaToast_string, Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        //Toast para avisar que o CPF já está registrado
                        Toast.makeText(getActivity(), R.string.CPFRegistradoToast_string, Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    //Toast para avisar que há algum campo não preenchido no formulário
                    Toast.makeText(getActivity(), R.string.faltaInfoToast_string, Toast.LENGTH_SHORT).show();
                }

            }
        });

        return v;

    }

}
