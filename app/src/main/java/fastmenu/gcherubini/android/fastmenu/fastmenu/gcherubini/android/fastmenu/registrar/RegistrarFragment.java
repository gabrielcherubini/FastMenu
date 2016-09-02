package fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.registrar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import fastmenu.gcherubini.android.fastmenu.R;
import fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.superclasses.Mask;
import fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.superclasses.Usuario;

/**
 * Created by G.Cherubini on 09/08/2016.
 */
public class RegistrarFragment extends Fragment
{
    //Declaração dos widgets do fragment
    protected Button mRegistrarButtonRegistrar;
    protected EditText mNomeEditTextRegistrar;
    protected EditText mSobrenomeEditTextRegistrar;
    protected EditText mTelefoneEditTextRegistrar;
    protected EditText mCPFEditTextRegistrar;
    protected EditText mEmailEditTextRegistrar;
    protected EditText mSenhaEditTextRegistrar;
    protected EditText mSenha2EditTextRegistrar;

    protected TextView mTelefoneTextViewRegistrar;
    protected TextView mCPFTextViewRegistrar;
    protected TextView mSenhaTextViewRegistrar;
    protected TextView mSenha2TextViewRegistrar;

    protected Usuario usuarioRegistro;
    protected boolean flagErro;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_registrar, container, false);

        //Referências dos TextViews de verificação
        mTelefoneTextViewRegistrar = (TextView)v.findViewById(R.id.telefone_textView);
        mCPFTextViewRegistrar = (TextView)v.findViewById(R.id.cpf_textView);
        mSenhaTextViewRegistrar = (TextView)v.findViewById(R.id.senha_textView);
        mSenha2TextViewRegistrar = (TextView)v.findViewById(R.id.senha2_textView);


        //Definindo as referências dos EditText
        mNomeEditTextRegistrar = (EditText)v.findViewById(R.id.nomeRegistrar_editText);
        mSobrenomeEditTextRegistrar = (EditText)v.findViewById(R.id.sobrenomeRegistrar_editText);
        mEmailEditTextRegistrar = (EditText)v.findViewById(R.id.emailRegistrar_editText);
        mSenhaEditTextRegistrar = (EditText)v.findViewById(R.id.senhaRegistrar_editText);
        mSenha2EditTextRegistrar = (EditText)v.findViewById(R.id.senha2Registrar_editText);

        //Campos com máscaras
        mTelefoneEditTextRegistrar = (EditText)v.findViewById(R.id.telefoneRegistrar_editText);
        mCPFEditTextRegistrar = (EditText)v.findViewById(R.id.cpfRegistrar_editText);

        //Adicionando máscaras aos campos
        mTelefoneEditTextRegistrar.addTextChangedListener(Mask.insert(false, mTelefoneEditTextRegistrar));
        mCPFEditTextRegistrar.addTextChangedListener(Mask.insert(true, mCPFEditTextRegistrar));

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
                //Limpa o campo quando o foco chega até ele
                if (!hasFocus)
                {
                    mTelefoneEditTextRegistrar.setText(null);
                }
                else
                {
                    if(VerificaFormulario.isTelOK(mTelefoneEditTextRegistrar.getText().toString()))
                    {
                        mTelefoneTextViewRegistrar.setText(R.string.ok_string);
                        flagErro = false;
                    }
                    else
                    {
                        mTelefoneTextViewRegistrar.setText(R.string.telefoneInvalido_string);
                        flagErro = true;
                    }
                }
            }
        });

        mCPFEditTextRegistrar.setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
            @Override
            public void onFocusChange(View v, boolean hasFocus)
            {
                if (!hasFocus)
                {
                    mCPFEditTextRegistrar.setText(null);
                }
                else
                {
                    if(VerificaFormulario.isCPFOK(mCPFEditTextRegistrar.getText().toString()) &&
                            VerificaFormulario.isCPFAvailable(mCPFEditTextRegistrar.getText().toString()))
                    {
                        mCPFTextViewRegistrar.setText(R.string.ok_string);
                        flagErro = false;
                    }
                    else
                    {
                        if(!VerificaFormulario.isCPFOK(mCPFEditTextRegistrar.getText().toString()))
                        {
                            mCPFTextViewRegistrar.setText(R.string.CPFInvalido_string);
                            flagErro = true;
                        }
                        else if(!VerificaFormulario.isCPFAvailable(mCPFEditTextRegistrar.getText().toString()))
                        {
                            mCPFTextViewRegistrar.setText(R.string.CPFRegistrado_string);
                            flagErro = true;
                        }
                    }

                }
            }
        });

        mSenhaEditTextRegistrar.setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
            @Override
            public void onFocusChange(View v, boolean hasFocus)
            {
                if (!hasFocus)
                {
                    mSenhaEditTextRegistrar.setText(null);
                }
                else
                {
                    if (VerificaFormulario.isPasswordOk(mSenhaEditTextRegistrar.getText().toString()))
                    {
                        mSenhaTextViewRegistrar.setText(R.string.ok_string);
                        flagErro = false;
                    }
                    else
                    {
                        mSenhaTextViewRegistrar.setText(R.string.senhaInvalida_string);
                        flagErro = true;
                    }

                }
            }
        });

        mSenha2EditTextRegistrar.setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
            @Override
            public void onFocusChange(View v, boolean hasFocus)
            {
                if (!hasFocus)
                {
                    mSenha2EditTextRegistrar.setText(null);
                }
                else
                {
                    if (VerificaFormulario.arePasswordsSame(mSenhaEditTextRegistrar.getText().toString(), mSenha2EditTextRegistrar.getText().toString()))
                    {
                        mSenha2TextViewRegistrar.setText(R.string.ok_string);
                        flagErro = false;
                    }
                    else
                    {
                        mSenha2TextViewRegistrar.setText(R.string.senhaDiferente_string);
                        flagErro = true;
                    }

                }
            }
        });

        return v;

    }

}
