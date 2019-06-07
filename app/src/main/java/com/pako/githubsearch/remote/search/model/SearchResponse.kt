package com.pako.githubsearch.remote.search.model

import com.pako.githubsearch.domain.search.model.User

data class SearchResponse(val total_count: Int, val incomplete_results: Boolean, val items: List<User>)