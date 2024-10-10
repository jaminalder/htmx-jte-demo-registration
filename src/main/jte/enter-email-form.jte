@import com.example.demoreg.EnterEmailViewModel

@param EnterEmailViewModel model

<form hx-post="/enter-email" class="flex flex-col flex-grow w-full">
    <h3 class="text-xl text-gray-600 text-center mb-6">Enter Email</h3>
    <div class="flex-1 flex flex-col justify-center">
        <div class="mb-4">
            @template.textfield-component(model = model.getEmailTextField())
        </div>
    </div>

    <button type="submit"
            class="w-full bg-blue-500 hover:bg-blue-600 text-white font-bold py-2 px-4 rounded-lg">
        Submit
    </button>
</form>