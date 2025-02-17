package com.maddyhome.idea.vim.vimscript.model.statements

import com.intellij.openapi.actionSystem.DataContext
import com.intellij.openapi.editor.Editor
import com.maddyhome.idea.vim.vimscript.model.Executable
import com.maddyhome.idea.vim.vimscript.model.ExecutionResult
import com.maddyhome.idea.vim.vimscript.model.VimContext
import com.maddyhome.idea.vim.vimscript.model.expressions.Scope
import com.maddyhome.idea.vim.vimscript.services.FunctionStorage

data class FunctionDeclaration(
  val scope: Scope?,
  val name: String,
  val args: List<String>,
  val body: List<Executable>,
  val replaceExisting: Boolean,
  val scriptName: String? = null,
) : Executable {

  override fun execute(editor: Editor, context: DataContext, vimContext: VimContext): ExecutionResult {
    FunctionStorage.storeFunction(this, vimContext)
    return ExecutionResult.Success
  }
}
