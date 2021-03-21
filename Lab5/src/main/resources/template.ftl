<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #aaaaaa;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>
<table style="width:100%">
    <tr>
        <th>Name</th>
        <th>Path</th>
    </tr>
    <#list items as item>
        <tr>
            <th>${item.name}</th>
            <th>${item.path}</th>
        </tr>
    </#list>
</table>
</body>
</html>