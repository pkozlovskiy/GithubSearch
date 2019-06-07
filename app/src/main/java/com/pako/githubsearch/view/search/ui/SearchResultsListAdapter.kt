package com.pako.githubsearch.view.search.ui


import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import com.arlib.floatingsearchview.util.Util
import com.pako.githubsearch.R
import com.pako.githubsearch.domain.search.model.User

import java.util.ArrayList

class SearchResultsListAdapter : RecyclerView.Adapter<SearchResultsListAdapter.ViewHolder>() {

    private var mDataSet: List<User> = ArrayList()

    private var mLastAnimatedItemPosition = -1

    private var mItemsOnClickListener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onClick(user: User)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val mName: TextView
        val mAvatar: ImageView

        init {
            mName = view.findViewById(R.id.user_name)
            mAvatar = view.findViewById(R.id.user_avatar)
        }
    }

    fun swapData(mNewDataSet: List<User>) {
        mDataSet = mNewDataSet
        notifyDataSetChanged()
    }

    fun setItemsOnClickListener(onClickListener: OnItemClickListener) {
        this.mItemsOnClickListener = onClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultsListAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.search_results_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchResultsListAdapter.ViewHolder, position: Int) {
        val (login) = mDataSet[position]
        holder.mName.text = login

        if (mLastAnimatedItemPosition < position) {
            animateItem(holder.itemView)
            mLastAnimatedItemPosition = position
        }

        if (mItemsOnClickListener != null) {
            holder.itemView.setOnClickListener { mItemsOnClickListener!!.onClick(mDataSet[position]) }
        }
    }

    override fun getItemCount(): Int {
        return mDataSet.size
    }

    private fun animateItem(view: View) {
        view.translationY = Util.getScreenHeight(view.context as Activity).toFloat()
        view.animate()
            .translationY(0f)
            .setInterpolator(DecelerateInterpolator(3f))
            .setDuration(700)
            .start()
    }
}