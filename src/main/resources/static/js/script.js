
document.addEventListener('DOMContentLoaded', function() {
    // status用のセレクトボックスの要素を取得
    var statusSelectElement = document.getElementById('status');
    // priority用のセレクトボックスの要素を取得
    var prioritySelectElement = document.getElementById('priority');
    
    // セレクトボックスの色を更新する関数
    function updateSelectColor(selectElement) {
        var selectedOption = selectElement.options[selectElement.selectedIndex];
        selectElement.className = ''; // 既存のクラスをクリア
        selectElement.classList.add(selectedOption.className);
    }

    // 初期状態を設定
    updateSelectColor(statusSelectElement);
    updateSelectColor(prioritySelectElement);

    // 選択が変更されたときに色を更新
    statusSelectElement.addEventListener('change', function() {
        updateSelectColor(statusSelectElement);
    });

    // 選択が変更されたときに色を更新
    prioritySelectElement.addEventListener('change', function() {
        updateSelectColor(prioritySelectElement);
    });
});
//
//
//// 優先度でソートする関数
//function sortByPriority() {
//    var tableBody = document.querySelector("tbody");
//    var rows = Array.from(tableBody.querySelectorAll("tr"));
//
//    rows.sort(function(rowA, rowB) {
//        var priorityA = rowA.querySelector(".priority").textContent;
//        var priorityB = rowB.querySelector(".priority").textContent;
//        // ここで優先度を比較してソートします。
//        // "LOW", "MEDIUM", "HIGH" などの文字列として比較することができます。
//        if (priorityA < priorityB) return -1;
//        if (priorityA > priorityB) return 1;
//        return 0;
//    });
//
//    // ソートされた行をテーブルに再配置
//    rows.forEach(function(row) {
//        tableBody.appendChild(row);
//    });
//}
//
//// ボタンがクリックされたときにソート関数を呼び出す
//document.getElementById("sort-by-priority-button").addEventListener("click", function() {
//    sortByPriority();
//});

