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
import fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.superclasses.Mask;
import fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.superclasses.Usuario;

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
    protected EditText mSenhaEditTextRegistrar;
    protected EditText mSenha2EditTextRegistrar;

    protected Usuario usuarioRegistro;

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
        mEmailEditTextRegistrar = (EditText)v.findViewById(R.id.emailRegistrar_editText);
        mSenhaEditTextRegistrar = (EditText)v.findViewById(R.id.senhaRegistrar_editText);
        mSenha2EditTextRegistrar = (EditText)v.findViewById(R.id.senha2Registrar_editText);

        //Campos com máscaras
        mTelefoneEditTextRegistrar = (EditText)v.findViewById(R.id.telefoneRegistrar_editText);
        mCPFEditTextRegistrar = (EditText)v.findViewById(R.id.cpfRegistrar_editText);

        mTelefoneEditTextRegistrar.addTextChangedListener(Mask.insert("(##)####-####", mTelefoneEditTextRegistrar));

        //Deixando o valor inicial das strings como null
        mNomeEditTextRegistrar.setText(null);
        mSobrenomeEditTextRegistrar.setText(null);
        mTelefoneEditTextRegistrar.setText(null);
        mCPFEditTextRegistrar.setText(null);
        mEmailEditTextRegistrar.setText(null);
        mSenhaEditTextRegistrar.setText(null);
        mSenha2EditTextRegistrar.setText(null);

        //Click Listener no botão "Registrar"
        mRegistrarButtonRegistrar = (Button)v.findViewById(R.id.registrarRegistrar_button);
        mRegistrarButtonRegistrar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Inicializando classe para registro dos usuários
                usuarioRegistro = new Usuario(mNomeEditTextRegistrar.getText().toString(),mSobrenomeEditTextRegistrar.getText().toString(),
                        mTelefoneEditTextRegistrar.getText().toString(),mCPFEditTextRegistrar.getText().toString(),mEmailEditTextRegistrar.getText().toString(),
                        mSenhaEditTextRegistrar.getText().toString());



            }
        });

        mTelefoneEditTextRegistrar.setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
            @Override
            public void onFocusChange(View v, boolean hasFocus)
            {
                if (!hasFocus)
                {
                    mTelefoneEditTextRegistrar.setText(null);
                }
                else
                {

                }
            }
        });

        return v;

    }

}
