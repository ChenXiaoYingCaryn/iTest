calculateTimeDiff= function (createTime) {
    let videoTimeDiff = ''
    const newTime = new Date() // 获取现在的时间
    var updateTime = new Date(Date.parse(createTime)) // 转换上传时间字符串为date
    const timeDiff = newTime.getTime() - updateTime.getTime() // 现在时间距离上传时间的时间差（毫秒）
    const dayDiff = timeDiff / (24 * 3600 * 1000) // 天数差

    if (dayDiff >= 7) {
      const weekDiff = dayDiff / 7
      if (weekDiff >= 4) {
        const monthDiff = dayDiff / 30
        if (monthDiff >= 12) {
          videoTimeDiff = Math.floor(monthDiff / 12) + '年前'
          return videoTimeDiff
        }
        videoTimeDiff = Math.floor(monthDiff) + '个月前'
        return videoTimeDiff
      }
      videoTimeDiff = Math.floor(weekDiff) + '周前'
      return videoTimeDiff
    } else if (dayDiff < 1) {
      const hourDiff = dayDiff * 24
      if (hourDiff < 1) {
        const minuteDiff = hourDiff * 60
        if (minuteDiff < 3) {
          videoTimeDiff = '刚刚'
          return videoTimeDiff
        }
        videoTimeDiff = Math.floor(minuteDiff) + '分钟前'
        return videoTimeDiff
      }
      videoTimeDiff = Math.floor(hourDiff) + '小时前'
      return videoTimeDiff
    } else {
      videoTimeDiff = Math.floor(dayDiff) + '天前'
      return videoTimeDiff
    }
  }
