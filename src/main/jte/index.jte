<!DOCTYPE html>
<html data-theme="light">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Demo Registration</title>
    <link href="https://cdn.jsdelivr.net/npm/daisyui@4.12.13/dist/full.min.css" rel="stylesheet" type="text/css" />
    <script src="https://unpkg.com/htmx.org@1.9.10"></script>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-800 flex items-center justify-center min-h-screen">

<div class="w-full max-w-sm bg-white p-8 rounded-md shadow-md mx-4 sm:mx-auto h-full min-h-[40vh] flex flex-col">

    <h2 class="text-2xl font-semibold text-gray-800 text-center mb-6">Demo Registration</h2>

    <div id="step-content" hx-get="/enter-email-form" hx-trigger="load" class="flex flex-col flex-grow h-full">
        <span id="spinner" class="htmx-indicator loading loading-spinner loading-lg justify-center items-center"></span>
    </div>

</div>

</body>
</html>