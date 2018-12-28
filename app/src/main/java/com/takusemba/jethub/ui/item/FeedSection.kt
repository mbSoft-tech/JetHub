package com.takusemba.jethub.ui.item

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.takusemba.jethub.model.Repository
import com.takusemba.jethub.viewmodel.FeedViewModel
import com.xwray.groupie.Item
import com.xwray.groupie.Section

class FeedSection(
  lifecycleOwner: LifecycleOwner,
  feedViewModel: FeedViewModel
) : Section() {

  init {
    feedViewModel.hotRepos.observe(lifecycleOwner, Observer { repositories ->
      updateResult(repositories)
    })
  }

  private fun updateResult(repositories: List<Repository>) {
    val items = mutableListOf<Item<*>>()
    (repositories).mapTo(items) { repository -> RepositoryItem(repository) }
    update(items)
  }
}