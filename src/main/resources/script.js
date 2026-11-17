const menuItems = [
    { name: "Paneer Tikka", category: "starters", price: "₹240" },
    { name: "Chicken Wings", category: "starters", price: "₹320" },
    { name: "Butter Chicken", category: "mains", price: "₹450" },
    { name: "Veg Biryani", category: "mains", price: "₹280" }
];

function displayMenu(items) {
    const container = document.getElementById('menu-container');
    container.innerHTML = items.map(item => `
        <div class="menu-item" data-category="${item.category}">
            <h3>${item.name}</h3>
            <p class="price">${item.price}</p>
        </div>
    `).join('');
}

function filterMenu(category) {
    document.querySelectorAll('.category-filter button').forEach(btn => btn.classList.remove('active'));
    event.target.classList.add('active');

    if (category === 'all') {
        displayMenu(menuItems);
    } else {
        displayMenu(menuItems.filter(item => item.category === category));
    }
}

window.onload = () => displayMenu(menuItems);