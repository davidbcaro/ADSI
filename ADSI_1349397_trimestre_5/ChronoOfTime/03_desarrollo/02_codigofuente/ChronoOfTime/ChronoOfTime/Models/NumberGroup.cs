using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace ChronoOfTime.Models
{
    public class NumberGroup
    {
        [Key]
        [Column(Order = 4)]
        public int IDNumberGroup { get; set; }

        [Display(Name = "Number Group")]
        [Required(ErrorMessage = "El campo Code es obligatorio")]
        public int numberGroup { get; set; }

        [Display(Name = "Date Start")]
        [Required(ErrorMessage = "El campo Code es obligatorio")]
        [DisplayFormat(DataFormatString = "{yyyy-MM-dd}", ApplyFormatInEditMode = true)]
        public DateTime dateStart { get; set; }

        [Display(Name = "Date End")]
        [Required(ErrorMessage = "El campo Code es obligatorio")]
        [DisplayFormat(DataFormatString = "{yyyy-MM-dd}", ApplyFormatInEditMode = true)]
        public DateTime dateEnd { get; set; }

        //foreign

        [Display(Name = "Rute")]
        [Required(ErrorMessage = "El campo Code es obligatorio")]
        public int IDRute { get; set; }
        [ForeignKey("IDRute")]
        public Rute Rute { get; set; }

        [Display(Name ="Program")]
        [Required(ErrorMessage = "El campo Code es obligatorio")]
        public int codeProgram { get; set; }
        [ForeignKey("codeProgram")]
        public Program Program { get; set; }





    }
}