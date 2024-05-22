document.addEventListener('DOMContentLoaded', function() {
    var selectElement = document.getElementById('status');

    function updateSelectColor() {
        var selectedOption = selectElement.options[selectElement.selectedIndex];
        selectElement.className = ''; // 既存のクラスをクリア
        selectElement.classList.add(selectedOption.className);
    }

    // 初期状態を設定
    updateSelectColor();

    // 選択が変更されたときに色を更新
    selectElement.addEventListener('change', updateSelectColor);
});
