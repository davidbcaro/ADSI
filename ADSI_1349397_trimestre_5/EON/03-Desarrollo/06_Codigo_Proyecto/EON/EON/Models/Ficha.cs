using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace EON.Models
{
    public class Ficha
    {
        [Key]
        [Display(Name = "idFicha")]
        public int id_Ficha { get; set; }

        [Display(Name = "numberFicha")]
        [Required(ErrorMessage = "Field {0} is required")]
        [StringLength(60, ErrorMessage = "Field {0} must contain a maximum of {1} characters and a minimum of (2) characters", MinimumLength = 1)]
        public string number_Ficha { get; set; }

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

        [Display(Name = "Route")]
        [Required(ErrorMessage = "Field {0} is required")]
        [StringLength(10, ErrorMessage = "Field {0} must contain a maximum of {1} characters and a minimum of (2) characters", MinimumLength = 1)]
        public string Route { get; set; }


        public int id_Status_Ficha { get; set; }
        public virtual StatusFicha StatusFicha { get; set; }

        public virtual ICollection<Schedule>schedule{ get; set; }
    }
}