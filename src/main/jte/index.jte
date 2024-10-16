<!DOCTYPE html>
<html data-theme="light">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Demo Registration</title>
    <link href="https://cdn.jsdelivr.net/npm/daisyui@4.12.13/dist/full.min.css" rel="stylesheet" type="text/css"/>
    <script src="https://unpkg.com/htmx.org@1.9.10"></script>
    <script src="https://cdn.tailwindcss.com"></script>
</head>

<body class="bg-gray-800 flex items-center justify-center min-h-screen">

<div class="w-full max-w-sm bg-white p-8 rounded-md shadow-md mx-4 sm:mx-auto h-full min-h-[40vh] flex flex-col">

    <h2 class="text-2xl font-semibold text-gray-800 text-center mb-6">Demo Registration</h2>

    <div id="step-content" hx-get="/enter-email-form" hx-trigger="load" hx-indicator="#spinner"
         class="flex flex-col flex-grow h-full">
        <div></div>
    </div>

</div>

<div id="spinner"
     class="htmx-indicator absolute bg-white bg-opacity-60 z-10 h-full w-full flex items-center justify-center">
    <div class="flex items-center">
        <span class="text-3xl mr-4">Loading</span>
        <svg class="animate-spin h-8 w-8 text-gray-800" xmlns="http://www.w3.org/2000/svg" fill="none"
             viewBox="0 0 24 24">
            <circle class="opacity-25" cx="12" cy="12" r="10" stroke="currentColor" stroke-width="4"></circle>
            <path class="opacity-75" fill="currentColor"
                  d="M4 12a8 8 0 018-8V0C5.373 0 0 5.373 0 12h4zm2 5.291A7.962 7.962 0 014 12H0c0 3.042 1.135 5.824 3 7.938l3-2.647z">
            </path>
        </svg>
    </div>
</div>
</body>

<style>
    .htmx-indicator {
        visibility: hidden;
    }

    .htmx-request .htmx-indicator {
        visibility: visible;
    }

    .htmx-request.htmx-indicator {
        visibility: visible;
    }
</style>

</html>