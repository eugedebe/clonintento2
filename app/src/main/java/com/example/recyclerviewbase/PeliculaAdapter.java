package com.example.recyclerviewbase;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;



public class PeliculaAdapter extends RecyclerView.Adapter {

    private List<Pelicula> peliculas;
    private NotificadorPeliculaCelda notificadorPeliculaCelda;

    //recibo en el constructor del adapter, un set de datos ya armado desde afuera
    //y me lo guardo como atributo
    public PeliculaAdapter(List<Pelicula> peliculas, NotificadorPeliculaCelda notificadorPeliculaCelda) {
        this.peliculas = peliculas;
        this.notificadorPeliculaCelda = notificadorPeliculaCelda;
    }

    /*
    public void agregarPelicula(Pelicula pelicula){
        peliculas.add(pelicula);
        notifyDataSetChanged();
    }*/


    //en este metodo debemos inflar nuesta celda (el xml armado) y pasarsela al viewholder
    //quien sera el que pegara la informacion dea pelicula en la celda que le pasemos.
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //me creo el inflador para inflar el xml de la celda hacia una View.
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.celda_recycler_peliculas, parent, false);
        //me creo un viewholder y le paso la View, que es la celda xml que inflamos
        ViewHolderPelicula viewHolderPelicula = new ViewHolderPelicula(view);
        return viewHolderPelicula;
    }

    //en este metodo recibimos una posicion, que es la posicion de la pelicula que debemos
    //mostrar en el recycler. Por lo que iremos con un GET a nuestro atributo (el set de datos)
    //y le pedirimos peliculas.get(position) lo que nos devuelvela pelicula en la posicion
    //recibida por parametro. Al viewholder que recibimos por parametro le pasamos esta
    //pelicula que obtuvimos, y el viewholder se encarga de volcar la info a la celda.
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Pelicula pelicula = peliculas.get(position);
        ViewHolderPelicula viewHolderPelicula = (ViewHolderPelicula) holder;
        viewHolderPelicula.cargarPelicula(pelicula);
    }


    //retorno el tamaño de mi atributo que es el set de datos
    @Override
    public int getItemCount() {
        if (peliculas != null) {
            return peliculas.size();
        } else {
            return 0;
        }
    }

    public void actualizarPelicula(Pelicula pelicula) {
        int indexPelicula = peliculas.indexOf(pelicula);
        notifyItemChanged(indexPelicula);
    }

    public class ViewHolderPelicula extends RecyclerView.ViewHolder {


        private ImageView imagenPelicula,imagenestadoFavorito;

        //este itemview es la celda construida
        public ViewHolderPelicula(View itemView) {
            super(itemView);

            imagenPelicula = itemView.findViewById(R.id.imagen_pelicula_id);
            imagenestadoFavorito= itemView.findViewById(R.id.favorito_id);

            imagenPelicula.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int posicionPeliculaClickeado = getAdapterPosition();
                    Pelicula pelicula = peliculas.get(posicionPeliculaClickeado);
                    notificadorPeliculaCelda.notificarPeliculaClickeado(pelicula);

                }
                
            });
            imagenestadoFavorito.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Pelicula pelicula = peliculas.get(getAdapterPosition());
                    pelicula.cambiarEstadoFav();

                    // TODO: 27/5/2018 crear la función setearImagenFavorito que haga este trabajo para no repetir codigo
                    if(pelicula.getEstaFavorito()){
                        MainActivity.datosIniciales.agregaraFavoritos(pelicula);
                    }else{
                        MainActivity.datosIniciales.removerFavoritos(pelicula);
                    }
                    notificadorPeliculaCelda.solicitudDeActualizacionAdapters(pelicula);
                }
            });
        }

        
        public void cargarPelicula(Pelicula pelicula) {
            //el pelicula que recibe deberia sacarle sus datos y pegarlos en la celda
// TODO: 27/5/2018 cambiar este hardcodeo para que sea facil el cambio de la imagen de favoritos ya que no está definida 
            imagenPelicula.setImageResource(pelicula.getImageRes());
            if(pelicula.getEstaFavorito()){
                imagenestadoFavorito.setImageResource(R.drawable.ic_favorite_black_24dp);
            }else{
                imagenestadoFavorito.setImageResource(R.drawable.ic_favorite_border_black_24dp);
            }
            
        }

    }

    //INTERFAZ QUE COMUNICA ADAPTER CON FRAGMENT. EL FRAGMENT ES QUIEN IMPLEMENTA ESTA INTERFAZ
    public interface NotificadorPeliculaCelda {
        public void notificarPeliculaClickeado(Pelicula pelicula);
        public void solicitudDeActualizacionAdapters(Pelicula pelicula);
    }
}
