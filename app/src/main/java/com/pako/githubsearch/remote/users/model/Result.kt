package com.pako.githubsearch.remote.users.model

import com.pako.githubsearch.data.User

data class Result(val total_count: Int, val incomplete_results: Boolean, val items: List<User>)