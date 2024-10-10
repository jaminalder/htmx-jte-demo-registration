@import com.example.demoreg.EnterTokenViewModel

@param EnterTokenViewModel model

<form hx-post="/enter-token" class="flex flex-col flex-grow w-full">
    <h3 class="text-xl text-gray-600 text-center mb-6">Enter Token</h3>
    <p class="text-gray-600">We just emailed you a token to ${model.getEmail()}. Please enter the token.</p>
    <div class="flex-1 flex flex-col justify-center">
        <div class="mb-4">
            @template.textfield-component(model = model.getTokenTextField())
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



