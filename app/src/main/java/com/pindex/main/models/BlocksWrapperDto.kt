package com.pindex.main.models

data class BlocksWrapperDto(
        var blocks: ArrayList<BlockDto>? = null,
        var type: BlocksWrapperCategoryEnum? = null,
)
