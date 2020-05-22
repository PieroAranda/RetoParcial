package com.example.xtrememovieapp.Activities

import android.app.Application
import android.os.AsyncTask
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.xtrememovieapp.Model.Favoritos
import com.example.xtrememovieapp.R
import com.example.xtrememovieapp.room.xtrememovieappDatabase
import kotlinx.android.synthetic.main.activity_favoritos.*

class FavoritosAdapter(private val favoritos: MutableList<Favoritos>, private val application: Application): RecyclerView.Adapter<FavoritosAdapter.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.TitleFavorite)
        val overview: TextView = itemView.findViewById(R.id.OverviewFavorite)
        val delete_icon: ImageView = itemView.findViewById(R.id.photoBorrar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.favorite_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = favoritos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val favorito = favoritos[position]
        holder.title.text = favorito.title
        holder.overview.text = favorito.overview

        holder.delete_icon.setOnClickListener(View.OnClickListener {
            val currentPosition:Int = favoritos.indexOf(favorito)
            DeleteFavorite(favorito.id,application).execute()
            favoritos.removeAt(currentPosition)
            notifyItemRemoved(currentPosition)
        }
        )
    }

    class DeleteFavorite(val id:Int,val application: Application):AsyncTask<Void,Void,Void>(){
        override fun doInBackground(vararg params: Void?): Void? {
            xtrememovieappDatabase.get(application).getxtrememovieappDAO().deleteFavorite(id)
            Log.d("Elimando Favoritos","Elimine")
            return null
        }
    }
}