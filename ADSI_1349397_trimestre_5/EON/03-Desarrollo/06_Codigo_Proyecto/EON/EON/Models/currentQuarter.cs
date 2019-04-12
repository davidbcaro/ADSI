using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace EON.Models
{
    public class currentQuarter
    {
        [Key]
        [Display(Name = "idcurrentQuarter")]
        public int id_current_Quarter { get; set; }

        [Display(Name = "idCurrentQuarter")]
        [Required(ErrorMessage = "Field {0} is required")]
        [StringLength(10, ErrorMessage = "Field {0} must contain a maximum of {1} characters and a minimum of (2) characters", MinimumLength = 1)]
        public string idcurrent_Quarter { get; set; }

        [Display(Name = "startDate")]
        [Required(ErrorMessage = "Field {0} is required")]
        [DataType(DataType.Date)]
        [DisplayFormat(DataFormatString = "{0:yyyy-MM-dd}", ApplyFormatInEditMode = true)]
        public DateTime start_Date { get; set; }

        [Display(Name = "endDate")]
        [Required(ErrorMessage = "Field {0} is required")]
        [DataType(DataType.Date)]
        [DisplayFormat(DataFormatString = "{0:yyyy-MM-dd}", ApplyFormatInEditMode = true)]
        public DateTime end_Date { get; set; }

        public virtual ICollection<Version> Versions { get; set; }
    }
}