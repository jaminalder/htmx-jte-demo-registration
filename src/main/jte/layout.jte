@param gg.jte.Content content

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Task Manager</title>
    <script src="https://unpkg.com/htmx.org@1.9.10"></script>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-800 flex items-center justify-center min-h-screen">

<div class="w-full max-w-sm bg-white p-8 rounded-md shadow-md mx-4 sm:mx-auto h-full min-h-[50vh] flex flex-col">

    <h2 class="text-2xl font-semibold text-gray-800 text-center mb-6">Demo Registration</h2>

    ${content}

</div>

</body>
</html>