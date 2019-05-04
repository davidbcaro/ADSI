using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace Tidsplan.Models
{
    public class Schedule
    {

        [Key]
        public int scheduleID { get; set; }

        [DataType(DataType.Date)]
        [DisplayFormat(ApplyFormatInEditMode = true, DataFormatString = "{0:MM/dd/yyyy}")]
        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Fecha de inicio")]
        public DateTime startDate { get; set; }

        [DataType(DataType.Date)]
        [DisplayFormat(ApplyFormatInEditMode = true, DataFormatString = "{0:MM/dd/yyyy}")]
        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Fecha final")]
        public DateTime endHDate { get; set; }

        [DataType(DataType.Time)]
        [DisplayFormat(ApplyFormatInEditMode = true, DataFormatString = "{0:HH:mm}")]
        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Hora de inicio")]
        public String startHour { get; set; }

        [DataType(DataType.Time)]
        [DisplayFormat(ApplyFormatInEditMode = true, DataFormatString = "{0:HH:mm}")]
        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Hora final")]
        public String endHour { get; set; }

        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Lunes")]
        public bool lunes { get; set; }

        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Martes")]
        public bool martes { get; set; }

        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Miercoles")]
        public bool miercoles { get; set; }

        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Jueves")]
        public bool jueves { get; set; }

        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Viernes")]
        public bool viernes { get; set; }

        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Sabado")]
        public bool sabado { get; set; }

        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Domingo")]
        public bool domingo { get; set; }

        [Required(ErrorMessage = "Es requerido.")]
        public int headquartesID { get; set; }
        public virtual Headquartes headquartes { get; set; }

        [Required(ErrorMessage = "Es requerido.")]
        public int EnvironID { get; set; }
        public virtual Environmentt environmentt { get; set; }
        [Required(ErrorMessage = "Es requerido.")]
        public int groupID { get; set; }
        public virtual Group group { get; set; }
        [Required(ErrorMessage = "Es requerido.")]
        public int instructorID{ get; set; }
        public virtual Instructor instructor { get; set; }
        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Versión")]
        public int version { get; set; }
        [Required(ErrorMessage = "Es requerido.")]
        public int trimesterID { get; set; }
        public virtual Trimester trimester { get; set; }
        [Required(ErrorMessage = "Es requerido.")]
        public int workingDayID { get; set; }
        public virtual WorkingDay workingDay { get; set; } 

    }
}