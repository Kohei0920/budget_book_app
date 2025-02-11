
const target = document.getElementById("firstForm")
const modalContent = document.getElementById('calendar')
const button = document.getElementById('calendar-btn')
const wrapper = document.getElementById('wrapper')
let inputDate = document.getElementById('input-value')
console.log(button)
target.addEventListener('click', modalOpen);
addEventListener('click', modalClose);

function modalOpen() {
	if (inputDate.value == "") {
		modalContent.style.display = 'block';
		button.style.display = 'block';
		wrapper.style.opacity = 0.3;
	}
}

function modalClose(e) {
	if (e.target.id === 'calendar' || e.target.classList.contains('calendar-td')) {
		modalContent.style.display = 'none';
		button.style.display = 'none';
		wrapper.style.opacity = 1;
	}
}

const weeks = ['日', '月', '火', '水', '木', '金', '土']
const date = new Date();
let year = date.getFullYear()
let month = date.getMonth() + 1
let monthView = date.getMonth() + 1
const day = date.getDate()

function createCalendar(year, month) {
	const startDate = new Date(year, month - 1, 1)
	const endDate = new Date(year, month, 0)
	console.log(startDate)
	const endDayCount = endDate.getDate()
	const startDay = startDate.getDay()
	const previousDate = new Date(year, month - 1, 0)
	const previousDayCount = previousDate.getDate()
	let previousFirstDayCount = previousDayCount - startDay + 1
	let dayCount = 1
	let dayCountView = 1
	let calendarHtml = ''

	calendarHtml += '<h1>' + year + '/' + month + '</h1>'
	calendarHtml += '<table class="calendar">'

	// //曜日の行を作成
	for (let i = 0; i < weeks.length; i++) {
		calendarHtml += '<td>' + weeks[i] + '</td>'
	}
	if (monthView < 10) {
		monthView = '0' + monthView
	}

	for (let w = 0; w < 6; w++) {
		calendarHtml += '<tr>'

		for (let d = 0; d < 7; d++) {
			if (w == 0 && d < startDay) {
				// calendarHtml += '<td></td>'
				calendarHtml += '<td id="is-disabled">' + previousFirstDayCount + '</td>'
				previousFirstDayCount++
			} else {
				if (dayCount <= endDayCount) {
					if (year === date.getFullYear() && month === date.getMonth() + 1 && dayCount === date.getDate()) {
						if (dayCountView < 10) {
							dayCountView = '0' + dayCountView
						}
						calendarHtml += '<td class="calendar-td calendar-today" data-date="' + year + '/' + monthView + '/' + dayCountView + '">' + dayCount + '</td>'
					} else {
						if (dayCountView < 10) {
							dayCountView = '0' + dayCountView
						}
//						console.log(dayCount)
						calendarHtml += '<td class="calendar-td" data-date="' + year + '/' + monthView + '/' + dayCountView + '">' + dayCount + '</td>'
					}
					dayCount++
					dayCountView++
				} else {
					let num = dayCount - endDayCount
					calendarHtml += '<td id="is-disabled">' + num + '</td>'
					dayCount++
				}
			}
		}
		calendarHtml += '</tr>'
	}
	calendarHtml += '</table>'

	return calendarHtml;

}

function moveCalendar(e) {
	document.querySelector('#calendar').innerHTML = ''
	if (e.target.id === 'prev') {
		month--
		monthView--

		if (month < 1) {
			year--
			month = 12
			monthView = 12
		}
	}

	if (e.target.id === 'next') {
		month++
		monthView++

		if (month > 12) {
			year++
			month = 1
			monthView = 1
		}
	}
	document.querySelector('#calendar').innerHTML = createCalendar(year, month)
}

document.querySelector('#calendar').innerHTML = createCalendar(year, month);

document.querySelector('#prev').addEventListener('click', moveCalendar)
document.querySelector('#next').addEventListener('click', moveCalendar)

document.addEventListener('click', function(e) {
	if (e.target.classList.contains('calendar-td')) {
		inputDate.value = e.target.dataset.date
		modalClose()
	}
})

