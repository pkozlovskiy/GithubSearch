package com.pako.githubsearch.view.search.ui


import android.graphics.Color
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import com.arlib.floatingsearchview.FloatingSearchView
import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion
import com.arlib.floatingsearchview.util.Util
import com.google.android.material.appbar.AppBarLayout
import com.pako.githubsearch.R
import com.pako.githubsearch.view.base.BaseFragment
import com.pako.githubsearch.view.search.model.UserSuggestion

class ScrollingSearchFragment : BaseFragment(), AppBarLayout.OnOffsetChangedListener {
    private val TAG = "BlankFragment"

    private var mSearchView: FloatingSearchView? = null
    private var mAppBar: AppBarLayout? = null

    private val mIsDarkSearchTheme = false

    private var mLastQuery = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_scrolling_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mSearchView = view.findViewById<View>(R.id.floating_search_view) as FloatingSearchView
        mAppBar = view.findViewById<View>(R.id.appbar) as AppBarLayout

        mAppBar!!.addOnOffsetChangedListener(this)

        setupDrawer()
        setupSearchBar()
    }

    private fun setupSearchBar() {
        mSearchView!!.setOnQueryChangeListener { oldQuery, newQuery ->
            if (oldQuery != "" && newQuery == "") {
                mSearchView!!.clearSuggestions()
            } else {

                //this shows the top left circular progress
                //you can call it where ever you want, but
                //it makes sense to do it when loading something in
                //the background.
                mSearchView!!.showProgress()

                //simulates a query call to a data source
                //with a new query.
                //                    DataHelper.findSuggestions(getActivity(), newQuery, 5,
                //                            FIND_SUGGESTION_SIMULATED_DELAY, new DataHelper.OnFindSuggestionsListener() {
                //
                //                                @Override
                //                                public void onResults(List<UserSuggestion> results) {
                //
                //                                    //this will swap the data and
                //                                    //render the collapse/expand animations as necessary
                //                                    mSearchView.swapSuggestions(results);
                //
                //                                    //let the users know that the background
                //                                    //process has completed
                //                                    mSearchView.hideProgress();
                //                                }
                //                            });
            }

            Log.d(TAG, "onSearchTextChanged()")
        }

        mSearchView!!.setOnSearchListener(object : FloatingSearchView.OnSearchListener {
            override fun onSuggestionClicked(searchSuggestion: SearchSuggestion) {

                val UserSuggestion = searchSuggestion as UserSuggestion
                //                DataHelper.findColors(getActivity(), UserSuggestion.getBody(),
                //                        new DataHelper.OnFindColorsListener() {
                //
                //                            @Override
                //                            public void onResults(List<User> results) {
                //                                //show search results
                //                            }
                //
                //                        });
                Log.d(TAG, "onSuggestionClicked()")

                mLastQuery = searchSuggestion.body ?: ""
            }

            override fun onSearchAction(query: String) {
                mLastQuery = query

                //                DataHelper.findColors(getActivity(), query,
                //                        new DataHelper.OnFindColorsListener() {
                //
                //                            @Override
                //                            public void onResults(List<User> results) {
                //                                //show search results
                //                            }
                //
                //                        });
                Log.d(TAG, "onSearchAction()")
            }
        })

        mSearchView!!.setOnFocusChangeListener(object : FloatingSearchView.OnFocusChangeListener {
            override fun onFocus() {

                //show suggestions when search bar gains focus (typically history suggestions)
                //                mSearchView.swapSuggestions(DataHelper.getHistory(getActivity(), 3));

                Log.d(TAG, "onFocus()")
            }

            override fun onFocusCleared() {

                //set the title of the bar so that when focus is returned a new query begins
                mSearchView!!.setSearchBarTitle(mLastQuery)

                //you can also set setSearchText(...) to make keep the query there when not focused and when focus returns
                //mSearchView.setSearchText(searchSuggestion.getBody());

                Log.d(TAG, "onFocusCleared()")
            }
        })


        //handle menu clicks the same way as you would
        //in a regular activity
        mSearchView!!.setOnMenuItemClickListener {
            //                if (item.getItemId() == R.id.action_change_colors) {
            //
            //                    mIsDarkSearchTheme = true;
            //
            //                    //demonstrate setting colors for items
            //                    mSearchView.setBackgroundColor(Color.parseColor("#787878"));
            //                    mSearchView.setViewTextColor(Color.parseColor("#e9e9e9"));
            //                    mSearchView.setHintTextColor(Color.parseColor("#e9e9e9"));
            //                    mSearchView.setActionMenuOverflowColor(Color.parseColor("#e9e9e9"));
            //                    mSearchView.setMenuItemIconColor(Color.parseColor("#e9e9e9"));
            //                    mSearchView.setLeftActionIconColor(Color.parseColor("#e9e9e9"));
            //                    mSearchView.setClearBtnColor(Color.parseColor("#e9e9e9"));
            //                    mSearchView.setDividerColor(Color.parseColor("#BEBEBE"));
            //                    mSearchView.setLeftActionIconColor(Color.parseColor("#e9e9e9"));
            //                } else {
            //
            //                    //just print action
            //                    Toast.makeText(getActivity().getApplicationContext(), item.getTitle(),
            //                            Toast.LENGTH_SHORT).show();
            //                }
        }

        //use this listener to listen to menu clicks when app:floatingSearch_leftAction="showHome"
        mSearchView!!.setOnHomeActionClickListener { Log.d(TAG, "onHomeClicked()") }

        /*
         * Here you have access to the left icon and the text of a given suggestion
         * item after as it is bound to the suggestion list. You can utilize this
         * callback to change some properties of the left icon and the text. For example, you
         * can load the left icon images using your favorite image loading library, or change text color.
         *
         *
         * Important:
         * Keep in mind that the suggestion list is a RecyclerView, so views are reused for different
         * items in the list.
         */
        mSearchView!!.setOnBindSuggestionCallback { suggestionView, leftIcon, textView, item, itemPosition ->
            val UserSuggestion = item as UserSuggestion

            val textColor = if (mIsDarkSearchTheme) "#ffffff" else "#000000"
            val textLight = if (mIsDarkSearchTheme) "#bfbfbf" else "#787878"

            if (UserSuggestion.isHistory) {
                leftIcon.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.ic_history_black_24dp, null
                    )
                )

                Util.setIconColor(leftIcon, Color.parseColor(textColor))
                leftIcon.alpha = .36f
            } else {
                leftIcon.alpha = 0.0f
                leftIcon.setImageDrawable(null)
            }

            textView.setTextColor(Color.parseColor(textColor))
            val text = UserSuggestion.body?.replaceFirst(
                mSearchView!!.query.toRegex(),
                "<font color=\"" + textLight + "\">" + mSearchView!!.query + "</font>"
            )
            textView.text = Html.fromHtml(text)
        }
    }

    override fun onOffsetChanged(appBarLayout: AppBarLayout, verticalOffset: Int) {
        mSearchView!!.translationY = verticalOffset.toFloat()
    }

    override fun onActivityBackPress(): Boolean {
        //if mSearchView.setSearchFocused(false) causes the focused search
        //to close, then we don't want to close the activity. if mSearchView.setSearchFocused(false)
        //returns false, we know that the search was already closed so the call didn't change the focus
        //state and it makes sense to call supper onBackPressed() and close the activity
        return mSearchView!!.setSearchFocused(false)
    }

    private fun setupDrawer() {
        attachSearchViewActivityDrawer(mSearchView!!)
    }

}
