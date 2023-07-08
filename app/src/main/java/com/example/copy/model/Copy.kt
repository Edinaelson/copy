package com.example.copy.model

class Copy {
    var iconDelete: Int? = 0
    var iconEdit: Int? = 0
    var iconCopy: Int? = 0
    var textCopy: String? = null
    var textCopyText: String? = null

    constructor(iconDelete: Int?, iconEdit: Int?, iconCopy: Int?, textCopy: String?, textCopyText: String?){
        this.iconDelete = iconDelete
        this.iconEdit = iconEdit
        this.iconCopy = iconCopy
        this.textCopy = textCopy
        this.textCopyText = textCopyText
    }
}