package panel.expansion.developer.lln.expansionpanel;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import panel.expansion.developer.lln.expansionpanel.viewgroup.ExpansionLayoutCollection;

public class ExpansionPanelSampleActivityRecycler extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expansion_panel_sample_recycler);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final RecyclerAdapter adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);

        final List<Object> list = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            list.add(new Object());
        }
        adapter.setItems(list);
    }

    public final static class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerHolder> {

        private final List<Object> list = new ArrayList<>();

        private final ExpansionLayoutCollection expansionsCollection = new ExpansionLayoutCollection();
        TextView textView;
        RelativeLayout relativeLayout;
        TextView version_android;
        TextView name_version;
        TextView description_android;

        final String[] number_version = {
                "1.6",
                "2.1",
                "2.2",
                "2.3",
                "3.0",
                "4.0",
                "4.1",
                "4.4",
                "5.0",
                "6.0",
                "7.0",
                "8.0",
                "9"
        };

        final String[] name_version_android = {
                "Donut",
                "Eclair",
                "Froyo",
                "Gingerbread",
                "Honeycomb",
                "Icecream",
                "Jelly Bean",
                "Kit Kat",
                "Lollipop",
                "Marshmallow",
                "Nougat",
                "Oreo",
                "Pie"

        };

        final String[] text_description = {
                "O Donut trouxe as informações do mundo para a ponta dos seus dedos com a Caixa de pesquisa rápida. Ele também plantou as sementes para que o Android se apresentasse em todas as formas e tamanhos, ao mesmo tempo em que o Android Market amadureceu.",
                "Com o Eclair, as telas de alta densidade exibiram planos de fundo interativos deslumbrantes e sensíveis ao toque. Dirija para qualquer lugar com a navegação passo a passo e as informações de trânsito em tempo real. Tudo isso diretamente no seu smartphone.",
                "O Froyo revelou smartphones extremamente rápidos, que podem ser controlados pelo som da sua voz, e os recursos de ponto de acesso garantiram que você estivesse sempre conectado.",
                "O Gingerbread tornou a experiência do Android mais simples e mais rápida para usuários e desenvolvedores. Os jogos chegaram a outro nível, a duração da bateria ficou maior, e a compatibilidade com NFC gerou toda uma nova categoria de apps.",
                "O Honeycomb deu início à era dos tablets com um design de interface flexível que apresenta imagens grandes e navegação contínua na tela.",
                "O Ice Cream Sandwich valorizou a personalização e o controle do usuário: personalize sua tela inicial, defina a quantidade de dados que você usa e compartilhe conteúdos instantaneamente quando desejar.",
                "A inteligência permeou todos os atributos do Jelly Bean, que inaugurou a era da assistência móvel personalizada com o Google Now. Ele também tornou as notificações mais acionáveis e permitiu que um dispositivo funcionasse para várias contas de usuário.",
                "O Android KitKat ajudou você a realizar tarefas apenas com o som da sua voz. Basta dizer \"Ok Google\" para iniciar a pesquisa por voz, enviar uma mensagem de texto, ver rotas ou até mesmo reproduzir uma música. E quando você está com o dispositivo em mãos, um novo design imersivo destaca o conteúdo para você.",
                "O Android está em telas grandes e pequenas, desde smartphones e tablets até relógios, TVs e carros. O Lollipop tem um estilo visual arrojado e a resposta tátil fluida do material design.",
                "Seu dispositivo móvel ficou ainda melhor: atalhos fáceis para respostas inteligentes com o Now a um toque, duração mais longa da bateria e novas permissões de apps que dão mais controle a você.",
                "O Android Nougat oferece mais maneiras de personalizar seu dispositivo Android. Decida como os dados são usados, a maneira como você é notificado e a aparência da tela.",
                "O Android Oreo ajuda a minimizar a atividade em segundo plano nos aplicativos que você usa menos, é a superpotência que você nem consegue ver.",
                "O Android 9 se adapta a você e ao modo como você usa seu telefone, aprendendo suas preferências conforme você progride. Sua experiência fica melhor e melhor ao longo do tempo, e isso mantém as coisas mais fáceis, por mais tempo."
        };

        public RecyclerAdapter() {
            expansionsCollection.openOnlyOne(true);
        }

        @Override
        public RecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return RecyclerHolder.buildFor(parent);
        }

        @Override
        public void onBindViewHolder(RecyclerHolder holder, int position) {
            holder.bind(list.get(position));
            expansionsCollection.add(holder.getExpansionLayout());
            relativeLayout = holder.itemView.findViewById(R.id.relativelayout);
            version_android = holder.itemView.findViewById(R.id.version_android);
            name_version = holder.itemView.findViewById(R.id.name_version);
            description_android = holder.itemView.findViewById(R.id.description_android);

            version_android.setText(number_version[position]);
            name_version.setText(name_version_android[position]);
            description_android.setText(text_description[position]);


        }

        @Override
        public int getItemCount() {
            return number_version.length;
        }

        public void setItems(List<Object> items) {
            this.list.addAll(items);
            notifyDataSetChanged();
        }

        public final static class RecyclerHolder extends RecyclerView.ViewHolder {

            private static final int LAYOUT = R.layout.expansion_panel_recycler_cell;

            ExpansionLayout expansionLayout;
            RelativeLayout layout;
            TextView version_android;
            TextView name_version;


            public static RecyclerHolder buildFor(ViewGroup viewGroup) {
                return new RecyclerHolder(LayoutInflater.from(viewGroup.getContext()).inflate(LAYOUT, viewGroup, false));
            }

            @SuppressLint("ResourceAsColor")
            public RecyclerHolder(View itemView) {
                super(itemView);
                expansionLayout = itemView.findViewById(R.id.expansionLayout);
                layout = itemView.findViewById(R.id.relativelayout);
                version_android = itemView.findViewById(R.id.version_android);
                name_version = itemView.findViewById(R.id.name_version);

                expansionLayout.addListener(new ExpansionLayout.Listener() {
                    @SuppressLint("ResourceAsColor")
                    @Override
                    public void onExpansionChanged(ExpansionLayout expansionLayout, boolean expanded) {

                        if (expansionLayout.isExpanded()) {
                            layout.setBackgroundColor(Color.parseColor("#2ecc71"));
                            version_android.setTextColor(Color.WHITE);
                            name_version.setTextColor(Color.WHITE);
                            Log.d("ExpansionLayout", "isExpanded");
                        }

                        if (expansionLayout.isCollapse()) {
                            layout.setBackgroundColor(Color.WHITE);
                            version_android.setTextColor(Color.BLACK);
                            name_version.setTextColor(Color.BLACK);
                            Log.d("ExpansionLayout", "isCollapse");
                        }
                    }
                });

            }

            public void bind(Object object) {
                expansionLayout.collapse(false);
            }

            public ExpansionLayout getExpansionLayout() {
                return expansionLayout;
            }
        }
    }
}
