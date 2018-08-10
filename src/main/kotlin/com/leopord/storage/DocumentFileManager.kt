package com.leopord.storage

import com.leopord.document.Document

abstract class DocumentFileManager {

    abstract fun saveDocument(document: Document)

    abstract fun saveAllDocuments(): Boolean
}