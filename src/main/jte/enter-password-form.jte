@import com.example.demoreg.view.enterpassword.EnterPasswordViewModel

@param EnterPasswordViewModel model

<form hx-post="/enter-password" hx-indicator="#spinner" class="flex flex-col flex-grow w-full">
    <h3 class="text-xl text-gray-600 text-center mb-6">Enter Password</h3>
    <div class="flex-1 flex flex-col justify-center">
        <label class="px-2 py-2">Password strength:</label>
        <progress class="progress progress-success w-full h-6 mb-12" value="${model.getPasswordStrength()}" max="100"></progress>
        <div class="mb-4">
            @template.textfield-component(model = model.getPasswordTextField())
            @template.textfield-component(model = model.getRepeatPasswordTextField())
        </div>
    </div>

    <button type="submit"
            class="w-full bg-blue-500 hover:bg-blue-600 text-white font-bold py-2 px-4 my-2 rounded-lg">
        Submit
    </button>

    <button hx-get="/enter-email-form"
            hx-target="#step-content"
            class="w-full bg-white text-gray-600 border border-gray-300 py-2 px-4 my-2 rounded-lg">
        Back
    </button>
</form>



