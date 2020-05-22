package com.example.xtrememovieapp.Activities

import android.app.Application
import android.os.AsyncTask
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.xtrememovieapp.Model.Favoritos
import com.example.xtrememovieapp.Model.Results
import com.example.xtrememovieapp.R
import com.example.xtrememovieapp.room.xtrememovieappDAO
import com.example.xtrememovieapp.room.xtrememovieappDatabase

class ResultsAdapter(private val results: List<Results>, private val application: Application) : RecyclerView.Adapter<ResultsAdapter.ViewHolder>() {

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.Title)
        val overview: TextView = itemView.findViewById(R.id.Overview)
        val favorite_icon: ImageView = itemView.findViewById(R.id.photo)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.result_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = results.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = results[position]
        holder.title.text = result.title
        holder.overview.text = result.overview
        val favoritos:List<Favoritos> = xtrememovieappDatabase.get(application).getxtrememovieappDAO().findFavorite(result.id)

        if (favoritos.isNotEmpty()){
            holder.favorite_icon.setImageResource(R.drawable.ic_star_black_24dp)
            holder.favorite_icon.isEnabled = false
        }

        holder.favorite_icon.setOnClickListener(View.OnClickListener {
                holder.favorite_icon.setImageResource(R.drawable.ic_star_black_24dp)
                InsertFavoriteData(Favoritos(result.id,result.title,result.overview),application).execute()
                holder.favorite_icon.isEnabled = false
            }
        )
    }

    class InsertFavoriteData(val favoritos: Favoritos,val application: Application):AsyncTask<Void,Void,Void>(){
        override fun doInBackground(vararg params: Void?): Void? {
            xtrememovieappDatabase.get(application).getxtrememovieappDAO().insertFavoritos(favoritos)
            xtrememovieappDatabase.get(application).getxtrememovieappDAO().getFavoritos().forEach {
                Log.d("Listar Favoritos","favorito:${it.title}")
            }
            return null
        }

    }

}
