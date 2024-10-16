@param com.example.demoreg.view.shared.TextFieldViewModel model

<label class="px-2 py-2">${model.getLabel()}</label>
<input name="${model.getName()}.value"
       class="w-full px-4 py-2 border border-gray-300 rounded-md"
       placeholder="${model.getPlaceholder()}"
       value="${model.getValue()}">
@if(model.getHint() != null)
    <p class="px-2 py-2 text-sm text-gray-800 italic">${model.getHint()}</p>
@endif
@if(model.getError() != null)
    <p class="text-red-600 px-2 py-2">${model.getError()}</p>
@endif

